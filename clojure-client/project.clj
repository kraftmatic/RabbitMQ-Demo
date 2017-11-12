(defproject clojure-client "0.1.0-SNAPSHOT"
  :description "A lightweight clojure application with RabbitMQ implementation via Longohr"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"],
                 [com.novemberain/langohr "3.6.1"]]
  :main clojure-client.core
  :source-paths ["src" "src/clojure_client"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
