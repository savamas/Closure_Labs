(ns labs-sem3.lab3.main)

(require '[labs-sem3.lab3.stdin-reader :as reader])

(use 'labs-sem3.lab3.lagrange-interpolation
     'labs-sem3.lab3.linear-segments-approximation)

(defn -main
  "Main.clj handles LinearApproximator & LagrangeInterpolator, dispatches functions corresponding to args"
  [method
   step
   & min-points]
  (if (= method "segments")
    (approximate (reader/read-points) (Float/parseFloat step))
    (interpolate (reader/read-points) (Float/parseFloat step) (Float/parseFloat (first min-points))))

  ;(doseq [i (csv/read-csv (BufferedReader. *in*) :separator \;)]
    ;  (println i))
    ;(println (map #(+ 10 (* % 10)) (range 0 1 0.25)))
  ;;(apply println (map #(str "\t" %1 ";" %2 "\n" ) (map #(+ 10 (* % 10)) (range 0 1 0.25)) (range 0 1 0.25)))
)