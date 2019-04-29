(ns labs-sem3.lab1.impl3)

(use 'clojure.set)

(defn sieve-primes
  "Sieve of Eratosthenes implementation"
  ([n]
   (sieve (sorted-set) (apply sorted-set (range 2 (inc n))) (+ n 2)))
  ([primes candset end]
   (let [prime (first candset)]
     (if ( > (* prime prime) end)
       (reduce + (clojure.set/union primes candset))
       (recur (conj primes prime)
              (clojure.set/difference candset (range prime end prime))
              end)))))

(dotimes [n 10]
  (time (sieve-primes 2000000)))