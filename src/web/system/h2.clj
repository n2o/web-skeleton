(ns web.system.h2
  (:require [com.stuartsierra.component :as component]
            [korma.db :as kdb]
            [horsch.use-cases.add-seminar :as save-seminar]))

(defrecord H2 [config connection]
  component/Lifecycle
  (start [this]
    (assoc this :connection (kdb/h2 {:db "resources/db/korma.db"})))
  (stop [this]
    (assoc this :connection nil)))

(defn h2 [config]
  (map->H2 {:config h2}))

(extend-protocol save-seminar/SaveSeminar
  H2
  (save-seminar [h2 seminar]
    (prn "Do some SQL inserts..." seminar)))
