(ns site.core
  (:require [hiccup.page :as hp]))

(defn base [global-meta contents]
  (hp/html5 {:lang "en" :itemtype "http://schema.org/Blog"}
            [:head
             [:title (:site-title global-meta)]
             [:meta {:charset "utf-8"}]
             [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
             [:meta {:name "viewport"
                     :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
             (hp/include-css "https://unpkg.com/basscss@8.0.1/css/basscss.min.css")
             (hp/include-css "https://fonts.googleapis.com/css?family=Open+Sans:400,400italic,600,600italic,700,700italic")]
            [:body {:style "font-family: 'Open Sans', sans-serif; max-width: 900px; margin: 40px auto;"}
             contents]))

