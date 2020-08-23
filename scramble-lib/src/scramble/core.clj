(ns scramble.core)

(defn- count-by-item [xs]
  (reduce #(assoc %1 %2 (inc (%1 %2 0)))
          {}
          xs))

(defn- reduce-counts [as bs]
  (letfn [(reducer [acc a]
            (let [v (acc a)]
              (if (nil? v)
                acc
                (let [d (dec v)]
                  (if (not (zero? d))
                    (assoc acc a d)
                    (let [r (dissoc acc a)]
                      (if (empty? r)
                        (reduced r)
                        r)))))))]
    (reduce reducer (count-by-item bs) as)))

(defn- scramble-impl? [as bs]
  (empty? (reduce-counts as bs)))

(defn ^Boolean scramble?
  "Returns true if a portion of str1 characters can be rearranged to match str2,
  otherwise returns false"
  [^String str1 ^String str2]
  (cond
    (or (nil? str1) (nil? str2))  false

    (zero? (count str2))          true
    (< (count str1) (count str2)) false

    :else
    (scramble-impl? (seq str1) (seq str2))))
