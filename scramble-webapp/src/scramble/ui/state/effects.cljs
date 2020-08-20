(ns scramble.ui.state.effects
  (:require [re-frame.core :as rf]
            [ajax.core :as ajax]))

;; todo: make the url configurable
(def ^:private api-endpoint "http://localhost:8080")

(rf/reg-event-fx
  :verify
  (fn [_ [_ str1 str2]]
    {:http-xhrio {:method          :get
                  :uri             api-endpoint
                  :params          {:str1 str1 :str2 str2}
                  :timeout         5000
                  :with-credentials false
                  :response-format (ajax/json-response-format {:keywords? true})
                  :on-success      [:on-verify-success]
                  :on-failure      [:on-verify-error]}}))
