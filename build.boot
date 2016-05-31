(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[perun "0.3.0" :scope "test"]
                 [hiccup "1.0.5"]
                 [pandeiro/boot-http "0.7.0"]
                 [hashobject/boot-s3 "0.1.2-SNAPSHOT"]])

(require '[io.perun :refer :all]
         '[pandeiro.boot-http :refer [serve]]
         '[hashobject.boot-s3 :refer :all])

(task-options!
  pom {:project 'snelgrove.tech
       :version "0.0.1"}
  s3-sync {
    :bucket "www.snelgrove.tech"
    :access-key (System/getenv "SNELGROVE_AWS_ACCESS_KEY")
    :secret-key (System/getenv "SNELGROVE_AWS_SECRET_KEY")
    :source "public"
    :options {"Cache-Control" "max-age=315360000, no-transform, public"}})

(deftask build
  "Build test blog. This task is just for testing different plugins together."
  []
  (comp (global-metadata)
        (markdown)
        ;(draft)
        (print-meta)
        (slug)
        ;(ttr)
        (word-count)
        (permalink)
        (canonical-url)
        ;(build-date)
        ;(gravatar :source-key :author-email :target-key :author-gravatar)
        (render :renderer 'site.post/render)
        (collection :renderer 'site.index/render :page "index.html" :filterer identity)
        ;(sitemap)
        ))

(deftask dev
  []
  (comp (watch)
        (build)
        (serve :resource-root "public")))

(deftask deploy
  []
  (comp (build)
        (target)
        (s3-sync)))
