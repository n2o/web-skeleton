(ns web.main
  (:require [reloaded.repl :as rrepl]
            [web.system]))

(defn -main [& args]
  (rrepl/go))


;; http://pedestal.io/guides/pedestal-with-component
