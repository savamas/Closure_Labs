(ns labs_sem3.lab1.impl1
  (:gen-class))

(defn root-1 [x]
  "Get the square root of X"
  (inc (long (Math/sqrt x))))

(defn range-1 [x]
  "Get all possible divisors"
  (range 2 (root-1 x)))

(defn filter-1 [x]
  "Return the LazySeq of divisors"
  (filter #(zero? (rem x %))
          (range-1 x)))

(def xf
  (comp
    (map #(+ 2 %))
    (filter #(empty? (filter-1 %)))))

(defn sum-of-primes [n]
  "Find sum of primes via transducer"
  (transduce xf + (range n)))

(println (sum-of-primes 2000000))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;  Another variant, but with infinite sequence in use
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;(defn sum-of-primes [n]
;  (->> (map #(+ 2 %) (take n (range)))
;       (filter #(empty? (filter-1 %)))
;       (reduce +)))
;
;(println (sum-of-primes 2000000))