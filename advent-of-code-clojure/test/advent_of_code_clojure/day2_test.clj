(ns advent-of-code-clojure.day2-test
  (:require [clojure.test :refer :all]
            [advent-of-code-clojure.day2 :as day2]
            [clojure.java.io :as io]))

(deftest example-test
  (testing "example day two."
    (let [input (slurp (io/resource "day2-example.txt"))
          answer (day2/solve input)]
      (is (= answer 8)))))

(deftest real-test
  (testing "real day two"
    (let [input (slurp (io/resource "day2-real.txt"))
          answer (day2/solve input)]
      (is (= answer 2162)))))

(deftest example-part2-test
  (testing "example day two part2."
    (let [input (slurp (io/resource "day2p2-example.txt"))
          answer (day2/solve-pt2 input)]
      (is (= answer 2286)))))

(deftest real-part2-test
  (testing "real day two part2."
    (let [input (slurp (io/resource "day2-real.txt"))
          answer (day2/solve-pt2 input)]
      (is (= answer 72513)))))
