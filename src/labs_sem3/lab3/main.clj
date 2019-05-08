(ns labs-sem3.lab3.main)

(require '[labs-sem3.lab3.io :as io])

(use 'labs-sem3.lab3.lagrange-interpolation
     'labs-sem3.lab3.linear-segments-approximation)

(defn get-x-values-range
  [min-points]
  (if (empty? min-points)
    2
    (Long/parseLong (first min-points))))

(def data-flow (io/read-points))

(defn -main
  "Main.clj handles LinearApproximator & LagrangeInterpolator, dispatches functions corresponding to args"
  [method
   step
   & min-points]
  (if (= method "segments")
    (approximate (io/read-points) (Float/parseFloat step))
    (interpolate (io/read-points) (Float/parseFloat step) (Float/parseFloat (first min-points))))
  ;
  ;
  ;(loop [curr-point (- (get-x-values-range min-points) 1)
  ;       prev-point 0]
  ;  (let [x-start (first (nth data-flow prev-point))
  ;        x-end (second (nth data-flow curr-point))
  ;        y-values-nodes (map #(first %) (take min-points (drop prev-point data-flow)))
  ;        x-values-nodes (map #(second %) (take min-points (drop prev-point data-flow)))]
  ;    (io/print-points (range x-start x-end step) (map #(reduce + (map * (basic-pol-coll % x-values-nodes) y-values-nodes)) (range x-start x-end step))))
  ;  (recur (inc curr-point) (inc prev-point)))
)