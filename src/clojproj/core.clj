(ns clojproj.core
  (:gen-class)
  (:require [compojure.core :refer [defroutes GET]]
            ;;[compojure.core :refer [defroutes GET POST]]
            [compojure.route :as route]
            [hiccup.page :refer [html5 include-css]]
            [ring.adapter.jetty :refer [run-jetty]]))

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defroutes app
           (GET "/"
                []
             (html5
               [:html
                [:head
                 [:title "Simple Page"]
                 (include-css "style.css")
                 (include-css "pure-min.css")]
                [:body
                 [:h1 "Hello from Clojure!"]
                 [:p "This is a simple one-page Ring/Jetty/Compojure/Hiccup app."]]]))
           (route/resources "/")
           (route/not-found "Not Found"))

(defn -main []
  (run-jetty app {:port 3000 :join? false})
  (println "Jetty has started on localhost:3000"))
