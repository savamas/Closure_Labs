(ns labs-sem3.lab3.linear-segments-approximation)

(require '[labs-sem3.lab3.stdout-writer :as printer])

(defn approximate
  "Linear segments approximation"
  [data-flow
   step]
  (loop [flow-iterator data-flow
         prev-point nil]
    (if-not (nil? prev-point)
      (do
        (let [x1 (Float/parseFloat (first prev-point))
              y1 (Float/parseFloat (nth prev-point 1))
              x2 (Float/parseFloat (first (first flow-iterator)))
              y2 (Float/parseFloat (nth (first flow-iterator) 1))
              k (/ (- y1 y2) (- x1 x2))
              b (/ (- (* x1 y1) (* x2 y1)) (- x1 x2))]
          (printer/print-points (range x1 x2 step) (map #(+ b (* % k)) (range x1 x2 step))))
        ))
    (recur (next flow-iterator) (first flow-iterator)))
)

