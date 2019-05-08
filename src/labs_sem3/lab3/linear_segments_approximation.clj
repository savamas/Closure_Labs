(ns labs-sem3.lab3.linear-segments-approximation)

(require '[labs-sem3.lab3.io :as io])

(defn approximate
  "Linear segments approximation"
  [data-flow
   step]
  (loop [curr-point 1]
    (let [x1 (first (nth data-flow (- curr-point 1)))
          y1 (second (nth data-flow (- curr-point 1)))
          x2 (first (nth data-flow curr-point))
          y2 (second (nth data-flow curr-point))
          k (/ (- y2 y1) (- x2 x1))
          b (/ (- (* x2 y1) (* x1 y2)) (- x2 x1))]
      (io/print-points (range x1 x2 step) (map #(+ b (* % k)) (range x1 x2 step))))
    (recur (inc curr-point)))
)

