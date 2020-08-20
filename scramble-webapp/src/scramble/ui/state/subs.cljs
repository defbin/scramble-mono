(ns scramble.ui.state.subs
  (:require [re-frame.core :as rf]))

(rf/reg-sub
  :result
  (fn [db _]
    (:result db)))

(defn result []
  (rf/subscribe [:result]))
