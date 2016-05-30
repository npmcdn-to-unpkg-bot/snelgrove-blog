(ns site.index
  (:require [hiccup.page :as hp]
            [site.core :as core]))

(defn render [{global-meta :meta posts :entries}]
  (core/base
   global-meta
   [:div
    [:h1 "The Snelgrove Blog"]
    [:h2 "Posts"]
    [:ul.list-reset
     (for [post posts]
       [:li
        [:a {:href (str (:slug post))
             :itemprop "name"
             :class "h2 hover-underline"} (:name post)]])]]))


