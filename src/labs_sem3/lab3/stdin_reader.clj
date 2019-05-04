(ns labs-sem3.lab3.stdin-reader
  (:require [clojure.data.csv :as csv])
  (:import (java.io BufferedReader)))

(defn read-points
  "Returns LazySeq of stdin"
  []
  (csv/read-csv (BufferedReader. *in*) :separator \;)
  )
