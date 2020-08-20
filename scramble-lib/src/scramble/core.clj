(ns scramble.core)

(defn- make-counter [xs]
  (reduce #(assoc %1 %2 (inc (%1 %2 0)))
          {}
          xs))

(defn- scramble-impl? [as bs]
  ;; todo: optimize
  (let [ac (make-counter as)
        bc (make-counter bs)]
    (every? (fn [[k v]] (>= (ac k 0) v))
            bc)))

(defn ^Boolean scramble?
  "Returns true if a portion of str1 characters can be rearranged to match str2,
  otherwise returns false"
  [^String str1 ^String str2]
  (scramble-impl? (seq str1) (seq str2)))
