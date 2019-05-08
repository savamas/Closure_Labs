(ns labs-sem3.lab3.lagrange-interpolation)

(require '[labs-sem3.lab3.io :as io])

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
  [data-flow
   step
   min-points]
  (loop [curr-point (- min-points 1)
         prev-point 0]
    (let [x-start (first (nth data-flow prev-point))
          x-end (second (nth data-flow curr-point))
          y-values-nodes (map #(first %) (take min-points (drop prev-point data-flow)))
          x-values-nodes (map #(second %) (take min-points (drop prev-point data-flow)))]
      (io/print-points (range x-start x-end step) (map #(reduce + (map * (basic-pol-coll % x-values-nodes) y-values-nodes)) (range x-start x-end step))))
    (recur (inc curr-point) (inc prev-point)))
  )