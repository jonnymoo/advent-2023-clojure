(ns advent-of-code-clojure.day1-test
  (:require [clojure.test :refer :all]
            [advent-of-code-clojure.day1 :as day1]
            [clojure.java.io :as io]))

(deftest example-test
  (testing "example day one."
    (let [input (slurp (io/resource "day1-example.txt"))
          answer (day1/solve input)]
      (is (= answer 142)))))

(deftest real-test
  (testing "real day one."
    (let [input (slurp (io/resource "day1-real.txt"))
          answer (day1/solve input)]
      (is (= answer 53221)))))

(deftest example-part2-test
  (testing "example day one part2."
    (let [input (slurp (io/resource "day1p2-example.txt"))
          answer (day1/solve input)]
      (is (= answer 281)))))
