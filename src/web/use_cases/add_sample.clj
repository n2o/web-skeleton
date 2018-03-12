(ns web.use-cases.add-sample
  (:require [clojure.spec.alpha :as s]))

(defn save-sample [_ sample])

(defn add-sample [context sample]
  {:pre [(s/valid? ::sample sample)]}
  (save-sample (:save-sample context) sample))

(defprotocol SaveSample
  (save-sample [this sample]))

(def sample (first (last (s/exercise :web.entities.sample/sample))))

(let [context {:save-sample (reify SaveSample
                              (save-sample [_ sample]
                                (prn :saved sample)))}])



