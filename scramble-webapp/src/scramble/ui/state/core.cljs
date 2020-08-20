(ns scramble.ui.state.core
  (:require [re-frame.core :as rf]
            [day8.re-frame.http-fx]
            [scramble.ui.state.subs]
            [scramble.ui.state.handlers]
            [scramble.ui.state.effects]))

(defn init []
  (rf/dispatch-sync [:app/init]))
