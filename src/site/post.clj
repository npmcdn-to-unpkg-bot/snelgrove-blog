(ns site.post
  (:require [hiccup.page :as hp]
            [site.core :as core]))

(defn render [{global-meta :meta posts :entries post :entry}]
  (core/base
   global-meta
   [:div
    [:h1 "The Snelgrove Blog"]
    (:content post)]))
