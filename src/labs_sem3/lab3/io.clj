(ns labs-sem3.lab3.io
  (:require [clojure.data.csv :as csv])
  (:import (java.io BufferedReader)))

(defn read-points
  "Returns LazySeq of stdin"
  []
  (csv/read-csv (BufferedReader. *in*) :separator \;))

(defn print-points
  "Formats & prints csv values"
  [x-values
   y-values]
  (csv/write-csv *out* (into [] (map #(vector (str (format "%.3f" %1)) (str (format "%.3f" %2))) x-values y-values)) :separator \;)
  (flush))

