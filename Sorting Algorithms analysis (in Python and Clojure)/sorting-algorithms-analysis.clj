;; Quicksort in Clojure
(defn quicksort [vector_numbers]
  (if (<= (count vector_numbers) 1) vector_numbers
      (let [pivot (nth vector_numbers (int (/ (count vector_numbers) 2))) count-pivot (count (filter #(= % pivot) vector_numbers))]
        (concat (quicksort (filter #(< % pivot) vector_numbers))
                (repeat count-pivot pivot) 
                (quicksort (remove #(<= % pivot) vector_numbers))))))

;; Mergesort in Clojure
(defn merge-lists [l1 l2]
  (loop [final-list [] left l1 right l2]
    (cond (empty? left) (concat final-list right)
    (empty? right) (concat final-list left)
    (< 0 (compare (first left) (first right))) (recur (conj final-list (first right)) left (rest right))
     :else (recur (conj final-list (first left)) (rest left) right))))
 
(defn mergesort [vector-numbers]
  (if (<= (count vector-numbers) 1) vector-numbers
    (apply merge-lists
      (map mergesort
        (split-at (int (/ (count vector-numbers) 2)) vector-numbers)))))

;; Testing
(= (quicksort [2 6 1 9 1]) [1 1 2 6 9]) ;; returns true
(= (mergesort [2 6 1 9 1]) [1 1 2 6 9]) ;; returns true
 
;; Quicksort in Python
;; def quickSort(arr, beg, end):
;;   if (beg < end):
;;     pivotIndex = partition(arr, beg, end)
;;     quickSort(arr, beg, pivotIndex)
;;     quickSort(arr, pivotIndex + 1, end)

;; def partition(arr, beg, end):
;;   pIndex = beg - 1
;;   for i in range(beg, end - 1):
;;     if arr[i] < pivot:
;;         temp = arr[i]
;;         arr[i] = arr[pIndex]
;;         arr[pIndex] = temp
;;         pIndex += 1
;;     temp = pivot 
;;     pivot = arr[pIndex + 1]
;;     arr[pIndex + 1] = temp
;;   return pIndex + 1
        
;; Mergesort in Python
 
;; def mergeSort(vector):
;;     if len(vector) < 2:
;;         return vector

;;     left = vector[0:len(vector)//2]
;;     right = vector[len(vector)//2:]

;;     left = mergeSort(left)
;;     right = mergeSort(right)

;;     return merge(left, right)
 
;; def merge(left, right):
;;     result = []
;;     while len(left) > 0 and len(right) > 0:
;;         if left[0] < right[0]:
;;             left = left[1:]
;;             result.append(left)
;;         else:
;;             right = right[1:]
;;             result.append(right)
 
;;     if len(left) > 0:
;;         result.append(left)
 
;;     if len(right) > 0:
;;         result.append(right)

;;     return result


;; Clojure Time Analysis 
(def sortedlist1 (quicksort (repeatedly 10000000 #(rand-int 10))))
(time (quicksort sortedlist1)) ;; "Elapsed time: 2984.469413 msecs" 
(def reverse-sortedlist1 (reverse (quicksort (repeatedly 1000000 #(rand-int 10)))))
(time (quicksort reverse-sortedlist1)) ;; "Elapsed time: 2144.477835 msecs"

(def sortedlist (mergesort (repeatedly 1000000 #(rand-int 10))))
(time (mergesort sortedlist)) ;; "Elapsed time: 7582.211382 msecs"
(def reverse-sortedlist (reverse (mergesort (repeatedly 1000000 #(rand-int 10)))))
(time (mergesort reverse-sortedlist)) ;; "Elapsed time: 10026.670797 msecs"

;; Python times analysis

;; import random, time

;; l = [random.randrange (1, 10, 1) for i in range (1000)]
;; sorted_list = quickSort (l, 0 , len (l) - 1)
;; start = time.time ()
;; quickSort (sorted_list, 0 , len (l) - 1)
;; end = time.time ()
;; print (end - start) 4.573790788650513 secs

;; reversed_sortedlist = list (reversed (sorted_list))
;; start = time.time ()
;; quickSort (reversed_sortedlist, 0 , len (l) - 1)
;; end = time.time ()
;; print (end - start) 4.423914909362793 secs

;; l = [random.randrange (1, 10, 1) for i in range (1000000)]
;; sorted_list = mergeSort (l)
;; start = time.time ()
;; mergeSort (sorted_list)
;; end = time.time ()
;; print (end - start) 10.6718590259552 secs

;; reversed_sortedlist = list (reversed (sorted_list))
;; start = time.time ()
;; mergeSort (reversed_sortedlist)
;; end = time.time ()
;; print (end - start) 10.37930965423584 secs

;; Evaluation:

;; What are you looking for in the evaluation section?

;; In general, Clojure outperformed Python as Clojure was faster than Python. However, it is mostly comparable as it is not a big difference, more so in the mergesort runtime. Clojure ws 2x faster than Python when it ran quicksort, so developers should choose Clojure over python when dealing with quicksorting problems. Closure supports tail recursion,while I did not use tail recursion (recur) in my solution, if implemented then it could possibly be further optimized as Python does not even support tail recursion. Python was better though at reverse sort order unlike Clojure during reverse-sorted mergesor, although still close to the sorted-list mergesort time.

;; I did expect Clojure to beat Python, since Python is infamous for being slow and I've researched that Clojure can get to Java's fast runtime, at times. Although, I didn't expect mergesort to have identical runtimes for both lists. Clojure was not easy to understand how to do the program as editing, indexing, and looping is different from a standard non-functional language, I would say Python's is still easier to implement as Python in nature is similar to pseudocode and is more intuitive than Clojure. Especially, as I always kept getting stackoverflow issues with Clojure. I expected Python to not compete with clojure but the times were mostly close to eachother. Lastly, still using Python is far more useful and easier than Clojure, even if it's faster for quicksort.

;; Extra information: "Both the imperative and the functional implementation have the same asymptotic complexity – O(N log(N)) in the average case and O(N2) in the worst case. But where the imperative implementation operates in place by modifying the argument array, the functional implementation returns a new sorted array and leaves the argument array unchanged. The functional implementation thus requires more transient memory than the imperative one." So Clojure in general will take more memory allocation that most languages, like Python, so I suspect at higher volumes stackoverflows or clojure might even slow down with bigger input. Python, while slow, can be used for a big dataset, as it's used for data science.

;; Extra Credit

(def sortedlist2 (sort (repeatedly 1000000 #(rand-int 10))))
(time (sort sortedlist2)) ;; "Elapsed time: 25.725572 msecs"
(def reverse-sortedlist2 (reverse (sort (repeatedly 1000000 #(rand-int 10)))))
(time (sort reverse-sortedlist2)) ;; "Elapsed time: 43.704297 msecs"

;; import random, time 

;; l = [random.randrange (1, 10, 1) for i in range (10)]

;; start = time.time ()
;; sorted_list = l.sort ()
;; end = time.time ()
;; print (end - start) 0.00405311584 msecs (I made the times to msecs to make it easier to compare)

;; reversed_sortedlist = list (reversed (l))
;; start = time.time ()
;; reversed_sortedlist.sort ()
;; end = time.time ()
;; print (end - start) 0.00190734863 msecs

;; It seems that Python's built-in sorting functions is FAAAAR superior than Clojure's. It would seem that perhaps my implementatation is too naive for each language so I am not getting the best performance as I could be from the programming languages. Still, my previous judgement to choose Python over Clojure was not in vain, as Python, while known for being slow, can still outperform clojure in terms of built-in sorting functions. "Python's default sort uses Tim Sort, which is a combination of both merge sort and insertion sort" (https://towardsdatascience.com/sorting-algorithms-with-python-4ec7081d78a1). "The sort built-in actually calls java.util.Arrays.sort" (https://stackoverflow.com/questions/49223608/time-complexity-of-built-in-sort-in-clojure). However, it actually has two implementations: "Arrays.sort uses dual-pivot Quicksort on primitives. It offers O (n log (n)) performance and is typically faster than traditional (one-pivot) Quicksort implementations. However, it uses a stable, adaptive, iterative implementation of mergesort algorithm for Array of Objects." (https://www.baeldung.com/java-sorting#:~:text=As%20mentioned%20in%20the%20official,algorithm%20for%20Array%20of%20Objects.). So Python's built-in sort function will be better as it is a Tim sort, which is a hybrid of two of the best sorting algorithms.