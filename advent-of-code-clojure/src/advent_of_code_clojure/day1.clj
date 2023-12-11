(ns advent-of-code-clojure.day1
  (:require [clojure.string :as str]))

(def ^:private numbers {"zero" 0 "one" 1 "two" 2 "three" 3 "four" 4
                        "five" 5 "six" 6 "seven" 7 "eight" 8 "nine" 9})

(defn- find-number-at-start [s]
  (some (fn [[word digit]]
          (when (.startsWith s word)
            (str digit)))
        numbers))

(defn- find-number-at-end [s]
  (some (fn [[word digit]]
          (when (.endsWith s word)
            (str digit)))
        numbers))

(defn- find-first [s]
  (let [first-char (first s)]
    (if (Character/isDigit first-char)
      (str first-char)
      (if-let [digit (find-number-at-start s)]
        digit
        (find-first (subs s 1))))))

(defn- find-last [s]
  (let [last-char (last s)]
    (if (Character/isDigit last-char)
      (str last-char)
      (if-let [digit (find-number-at-end s)]
        digit
        (find-last (subs s 0 (dec (count s))))))))

(defn- find-first-and-last [s]
  (let [first-digit (find-first s)
        last-digit (find-last s)]
    (Integer/parseInt (str first-digit last-digit))))

(defn solve [input]
  (let [lines (str/split-lines input)]
    (->> lines
         (map find-first-and-last)
         (reduce +))))