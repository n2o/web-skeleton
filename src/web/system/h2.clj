(ns web.system.h2
  (:require [com.stuartsierra.component :as component]
            [korma.db :as kdb]
            [web.use-cases.add-sample :as save-sample]))

(defrecord H2 [config cqonnection]
  component/Lifecycle
  (start [this]
    (assoc this :connection (kdb/h2 {:db "resources/db/korma.db"})))
  (stop [this]
    (assoc this :connection nil)))

(defn h2 [config]
  (map->H2 {:config h2}))

(extend-protocol save-sample/SaveSample
  H2
  (save-sample [h2 sample]
    (prn "Do some SQL inserts..." sample)))
