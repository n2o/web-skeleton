(ns web.system.routes)

(defn hello-world [request]
  {:status 200 :body "Hello, world!"})

(def routes
  #{["/" :get hello-world :route-name :greet]})
