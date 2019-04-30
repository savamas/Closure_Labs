(ns labs_sem3.lab1.impl2)

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

(defn is-prime [x]
  "Check if X is a prime number"
  (empty? (filter-1 x)))

(defn sum-of-primes [max]
  "Return the sum of primes with the upper bound"
  (let [result (atom 0)]
    (doseq [i (range 2 max)]
      (if (is-prime i)
        (swap! result #(+ % i)))
      )
    @result))

(println (sum-of-primes 2000000))