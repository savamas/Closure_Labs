(ns labs-sem3.lab3.lagrange-interpolation)

(defn factors
  [x
   x-to-eliminate
   x-values-nodes]
  (map #(/ (- x %) (- x-to-eliminate %)) (filter #(not= % x-to-eliminate) x-values-nodes))
  )

(defn basic-pol-coll
  [x
   x-values-nodes]
  (map #(reduce * 1 (factors x % x-values-nodes)) x-values-nodes)
  )

(defn interpolate
  "Lagrange interpolation"
  [x-values-nodes
   y-values-nodes
   step]
  (let [x-start (first x-values-nodes)
        x-end (last x-values-nodes)]
    (map #(reduce + (map * (basic-pol-coll % x-values-nodes) y-values-nodes)) (range x-start x-end step)))
)