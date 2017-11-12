(ns clojure-client.core
  (:gen-class)
  (:require [langohr.core      :as rmq]
            [langohr.channel   :as lch]
            [langohr.queue     :as lq]
            [langohr.consumers :as lc]
            [langohr.basic     :as lb]))

(def ^{:const true} qname "rabbit_demo")

(defn handle-delivery
  "Handles message delivery"
  [ch metadata payload]
  (println (format " [x] Received %s" (String. payload "UTF-8"))))

(defn -main
  [& args]
  (with-open [conn (rmq/connect)]
    (let [ch   (lch/open conn)]
      (lq/declare ch qname {:durable false :auto-delete true})
      (println " [*] Waiting for messages. To exit press CTRL+C")
      (lc/blocking-subscribe ch qname handle-delivery {:auto-ack true}))))

