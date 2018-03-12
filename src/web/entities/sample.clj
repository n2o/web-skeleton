(ns web.entities.sample
  (:require [clojure.spec.alpha :as s]))

(s/def ::hello string?)

(s/def ::sample string?)
