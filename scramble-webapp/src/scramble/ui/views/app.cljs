(ns scramble.ui.views.app
  (:require [re-frame.core :as rf]
            [scramble.ui.state.subs :as subs]))

(defn verify-button [on-click]
  [:button {:on-click (fn [e]
                        (.preventDefault e)
                        (on-click))} "Verify"])

(defn input [on-change]
  (fn []
    [:input {:on-change (fn [e] (on-change (-> e .-target .-value)))}]))


(defn result-view [result]
  [:div "Result: " (str result)])

(defn app []
  (let [result (subs/result)
        str1   (atom "")
        str2   (atom "")]
    (fn []
      [:div
       [input #(reset! str1 %)]
       [input #(reset! str2 %)]
       [verify-button #(rf/dispatch [:verify @str1 @str2])]
       (when-not (nil? @result)
         [result-view @result])])))

