(ns labs-sem3.lab3.linear-segments-approximation)

(defn approximate
  "Linear segments approximation"
  [x-values
   y-values
   step]
  (let [x1 (first x-values)
        x2 (second x-values)
        y1 (first y-values)
        y2 (second y-values)
        k (/ (- y2 y1) (- x2 x1))
        b (/ (- (* x2 y1) (* x1 y2)) (- x2 x1))]
      (map #(+ b (* % k)) (range x1 x2 step)))
)