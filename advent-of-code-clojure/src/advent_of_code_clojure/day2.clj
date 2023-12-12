(ns advent-of-code-clojure.day2
  (:require [clojure.string :as str]))

(defn- parse-color-group [group-str]
  (let [matches (re-seq #"(?i)\b(\d+)\s+(red|green|blue)\b" group-str)]
    (reduce (fn [acc [_, count, color]]
              (update acc (keyword color)
                      (fnil + 0) (Integer/parseInt count)))
            {:red 0 :green 0 :blue 0}
            matches)))

(defn- parse-game-string [game-str]
  (let [id (re-find #"\d+" game-str)
        groups (str/split game-str #";")
        color-groups (map parse-color-group groups)]
    {:id (Integer/parseInt id), :groups color-groups}))

(defn- is-possible? [game bag]
  (let [groups (:groups game)]
    (every? (fn [group]
              (and (<= (:red group) (:red bag))
                   (<= (:green group) (:green bag))
                   (<= (:blue group) (:blue bag))))
            groups)))

(defn- get-minimum-bag [game]
  (let [groups (:groups game)]
    {:red (reduce max (map :red groups))
     :green (reduce max (map :green groups))
     :blue (reduce max (map :blue groups))}))

(defn solve [input]
  (let [lines (str/split-lines input)]
    (reduce (fn [acc line]
              (let [game (parse-game-string line)]
                (if (is-possible? game {:red 12 :green 13 :blue 14})
                  (+ acc (game :id))
                  acc))
              )
            0
            lines)))

(defn solve-pt2 [input]
  (let [lines (str/split-lines input)]
    (reduce (fn [acc line]
              (let [game (parse-game-string line)
                    minimum-bag (get-minimum-bag game)] 
                  (+ acc (* (minimum-bag :red) (minimum-bag :green) (minimum-bag :blue)))))
            0
            lines)))