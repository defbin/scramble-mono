(ns scramble.ui.state.handlers
  (:require [re-frame.core :as rf]))

(rf/reg-event-db
  :app/init
  (constantly
    {:result nil}))

(defn- on-verify-done [db value]
  (assoc db :result value))

(rf/reg-event-db
  :on-verify-success
  (fn [db [_ result]]
    (on-verify-done db (:result result))))

(rf/reg-event-db
  :on-verify-error
  (fn [db _]
    (on-verify-done db {:result nil})))
