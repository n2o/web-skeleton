(defproject web "0.0.1-SNAPSHOT"
  :description "A web-application-skeleton based on pedestal and component"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/test.check "0.9.0"]
                 [io.pedestal/pedestal.service "0.5.3"]
                 [io.pedestal/pedestal.jetty "0.5.3"]

                 [com.stuartsierra/component "0.3.2"]
                 [org.danielsz/system "0.4.1"]
                 [reloaded.repl "0.2.4"]

                 [hiccup "2.0.0-alpha1"]

                 [korma "0.4.3"]
                 [com.h2database/h2 "1.4.196"]

                 [org.clojure/java.jdbc "0.7.5"]
                 [com.h2database/h2 "1.4.193"]

                 [ch.qos.logback/logback-classic "1.2.3" :exclusions [org.slf4j/slf4j-api]]
                 [org.slf4j/jul-to-slf4j "1.7.25"]
                 [org.slf4j/jcl-over-slf4j "1.7.25"]
                 [org.slf4j/log4j-over-slf4j "1.7.25"]]
  :min-lein-version "2.0.0"
  :resource-paths ["config", "resources"]
  ;; If you use HTTP/2 or ALPN, use the java-agent to pull in the correct alpn-boot dependency
  ;:java-agents [[org.mortbay.jetty.alpn/jetty-alpn-agent "2.0.5"]]
  :profiles {:dev {:dependencies [[io.pedestal/pedestal.service-tools "0.5.3"]]}
             :uberjar {:aot [web.main]}}
  ;; :repl-options {:init (do (require 'horsch.server)
  ;;                          (def the-server (horsch.server/run-dev)))}
  :main ^{:skip-aot true} web.main)

