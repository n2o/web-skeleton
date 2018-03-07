(ns web.system
  (:require [com.stuartsierra.component :as component]
            [reloaded.repl :refer [init start stop go reset set-init!]]
            [io.pedestal.http :as http]
            [web.system.pedestal :as web]
            [web.system.routes :as routes]))

(defn system [env]
  (component/system-map
   :service-map {:env env
                 ::http/routes routes/routes
                 ::http/type :jetty
                 ::http/port 8080
                 ::http/join? false}
   :pedestal (component/using (web/new-pedestal) [:service-map])))

(set-init! #(system :prod))
