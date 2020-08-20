(ns scramble.ui.core
  (:require [reagent.dom :as d]
            [scramble.ui.views.app :refer [app]]
            [scramble.ui.state.core :as state]))

(defn mount-root []
  (d/render [app] (.getElementById js/document "app")))

(defn ^:export main []
  (state/init)
  (mount-root))
