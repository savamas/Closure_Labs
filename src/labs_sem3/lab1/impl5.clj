(ns labs-sem3.lab1.impl5)

(defn sieve-primes [n]
  "Sieve of Eratosthenes implementation"
  (loop [last-tried 2 sift (range 2 (inc n))]
    (if
      (or (nil? last-tried) (> (* last-tried last-tried) n))
      (reduce + sift)
      (let [filtered (doall (filter #(or (= % last-tried) (< 0 (rem % last-tried))) sift))]
        (let [next-to-try (first (doall (filter #(> % last-tried) filtered)))]
          (recur next-to-try filtered))))))

(println (sieve-primes 2000000))