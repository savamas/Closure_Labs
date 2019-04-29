(ns labs-sem3.lab1.impl4)

(defn sieve-primes [n]
  "Sieve of Eratosthenes implementation"
  (loop [p 2
         marked #{}
         primes []]
    (let [mults (range (* p p) (inc n) p)

          next-p (->> p
                      (inc)
                      (iterate inc)
                      (remove marked)
                      (first))

          new-primes (conj primes p)]

      (if (>= (* p p) n)
        (reduce + (into new-primes (remove marked (range next-p (inc n)))))
        (recur next-p (into marked mults) new-primes)))))

(println (sieve-primes 2000000))
