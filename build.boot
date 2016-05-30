(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[perun "0.3.0" :scope "test"]
                 [hiccup "1.0.5"]
                 [pandeiro/boot-http "0.7.0"]])

(require '[io.perun :refer :all]
         '[pandeiro.boot-http :refer [serve]])

(deftask build
  "Build test blog. This task is just for testing different plugins together."
  []
  (comp (global-metadata)
        (markdown)
        (draft)
        (print-meta)
        (slug)
        (ttr)
        (word-count)
        (permalink)
        (canonical-url)
        (build-date)
        (gravatar :source-key :author-email :target-key :author-gravatar)
        (render :renderer 'site.post/render)
        (collection :renderer 'site.index/render :page "index.html" :filterer identity)
        (sitemap)))

(deftask dev
  []
  (comp (watch)
        (build)
        (serve :resource-root "public")))
