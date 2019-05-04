(ns labs-sem3.lab3.stdout-writer)

(defn print-points
  "Formats & prints csv values"
  [x-values
   y-values]
  (apply println (map #(str "\t" (format "%.1f" %1) ";" (format "%.1f" %2) "\n" ) x-values y-values))
)