(ns scramble.server
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [ring.middleware.params :refer [wrap-params]]
            [ring.middleware.json :refer [wrap-json-response]]
            [jumblerg.middleware.cors :refer [wrap-cors]]
            [ring.logger :refer [wrap-with-logger]]
            [ring.util.http-response :as hr]
            [scramble.core :refer [scramble?]])
  (:gen-class))

(defn handler [{:keys [query-params]}]
  (let [{:strs [str1 str2]} query-params]
    (if (or (nil? str1)
            (nil? str2))
      (hr/bad-request)
      (hr/ok {:result (scramble? str1 str2)}))))

(def app
  (-> handler
      wrap-with-logger
      (wrap-cors #".*")
      wrap-params
      wrap-json-response))

(defn -main []
  (run-jetty app {:port 8080}))
