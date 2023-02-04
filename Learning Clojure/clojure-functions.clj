1. ; A Clojure function called bill-total has one argument (vector) and returns the total of the bill.
(defn bill-total [bill] (def vector-length (count bill)) 
  (loop [i 0 bill bill total 0]
    (if (= i vector-length) ; returns the total once i = vector-length
      total
      (let [[vector-index] bill] (let [{price :price quantity :quantity} vector-index] (def iteration-price (* price quantity))) (recur (+ i 1) (subvec bill 1) (+ total iteration-price)))))) ;destructures vector to look at each map in bill and calculates the price (p*q) and adds it to total every iteration
(def bill [{:name "Green Tea Ice Cream" :price 2.5 :quantity 2}
           {:price 1.0 :name "Sticky Rice" :quantity 1} {:price 2.1 :name "Mango" :quantity 1} {:quantity 1 :price 1.0 :name "Sticky
Rice"}])
(bill-total bill)


2. ; Function add-to-bill that accepts two arguments. The first is a bill as above. The second argument is a vector of additional items. The method returns a new bill with the additional items.
(defn add-to-bill [bill items] (def copy-of-bill bill) (conj copy-of-bill {}) ;made a copy of bill to preserve bill and added an empty map because the function will access and delete every item in bill
     (def bill-quantity (let [[vector-index] bill] (let [{quantity :quantity} vector-index] quantity)))
     (def bill-name (let [[vector-index] copy-of-bill] (let [{name :name} vector-index] name)))
     (def items-name (let [[vector-index] items] (let [{name :name} vector-index] name)))
     (def items-length (count items)) 
     (loop [i 0 items items bill-items copy-of-bill] 
       (if (= i items-length)
         bill
           (if (= bill-name items-name) ;if the item is already in the bill object then it will add one to quantity instead otherwise it will append to the bill
             (assoc (let [[vector-index] bill] vector-index) :quantity (+ bill-quantity 1)) 
             (conj bill (let [[vector-index] items] vector-index))))
       (recur (+ i 1) (subvec items 1) (subvec bill-items 1))))
(def bill [{:name "Green Tea Ice Cream" :price 2.5 :quantity 2}
           {:price 1.0 :name "Sticky Rice" :quantity 1}])
(def items [{:price 2.1 :name "Mango" :quantity 1} {:quantity 1 :price 1.0 :name "Sticky Rice"}])
(add-to-bill bill items)

3. ; Function, divisors, with one argument, a positive integer. The function returns a sequence of the divisors of N.
(defn divisors ; finds all divisors and at the end appends itself since n is also a divisor of itself
     [n]
     (concat (filter (comp zero? (partial rem n)) (range 1 n)) [n]))
(divisors 50)

4. ; Function, abundance, that has one argument, an integer, and returns the sum of the proper divisors of the number minus the number itself.
(defn abundance ; finds largest possible abundant number it is imputed
     [n]
     (- (apply + (concat (filter (comp zero? (partial rem n)) (range 1 n)))) n))
(abundance 300)


5. ; Find all the abundant numbers less than 300.
(defn abundance 
  [n] 
  (loop [i 0 acc[]]
    (if (= i n) ; returns when i is n and accumulates all results into the accumulator (acc)
      acc
      (if (def potential_abunant_number_iteration (- (apply + (concat (filter (comp zero? (partial rem i)) (range 1 i)))) i)) (> potential_abunant_number_iteration 0)
          ((conj acc i))))
    (recur (+ i 1) acc)))
(abundance 300)

6. ; function, pattern-count, with two arguments. The first argument is a string, let's call
; it text, and the second argument is also a string call it a pattern. The function pattern count
; returns the number of times the pattern occurs in the text.
(defn pattern-count [text pattern] (def pattern-result 0)
  (loop [i 0]
    (if (= i (count text))
      (+ pattern-result 0))
    (def counter 0)
    (loop [j 0]
      (if (= counter (count pattern))
        (+ pattern-result 1)
        (if (= j (count pattern))
          (+ pattern-result 0)
          (if (= (nth text j) (nth pattern j))
            (+ counter 1)
            (if true (+ pattern-result 0)))))
      (recur (+ j 1)))
    (recur (+ i 1))) 
  ) 
(pattern-count "abaabab" "aba")
