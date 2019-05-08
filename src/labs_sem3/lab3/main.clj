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
  (loop [curr-point (- (get-x-values-range min-points) 1)
         prev-point 0]
    (let [x-start (first (nth data-flow prev-point))
          x-end (first (nth data-flow curr-point))
          y-values-nodes (map #(second %) (take (+ 1 (- curr-point prev-point)) (drop prev-point data-flow)))
          x-values-nodes (map #(first %) (take (+ 1 (- curr-point prev-point)) (drop prev-point data-flow)))]
      (if (= method "segments")
        (io/print-points (range x-start x-end (Float/parseFloat step)) (approximate x-values-nodes y-values-nodes (Float/parseFloat step)))
        (io/print-points (range x-start x-end (Float/parseFloat step)) (interpolate x-values-nodes y-values-nodes (Float/parseFloat step)))))
    (recur (inc curr-point) (inc prev-point)))
)