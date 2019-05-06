(ns labs-sem3.lab3.main)

(require '[labs-sem3.lab3.io :as io])

(use 'labs-sem3.lab3.lagrange-interpolation
     'labs-sem3.lab3.linear-segments-approximation)

(defn -main
  "Main.clj handles LinearApproximator & LagrangeInterpolator, dispatches functions corresponding to args"
  [method
   step
   & min-points]
  (if (= method "segments")
    (approximate (io/read-points) (Float/parseFloat step))
    (interpolate (io/read-points) (Float/parseFloat step) (Float/parseFloat (first min-points))))
)