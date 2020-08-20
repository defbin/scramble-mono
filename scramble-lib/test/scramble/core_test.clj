(ns scramble.core-test
  (:require [clojure.test :refer :all]
            [scramble.core :refer [scramble?]]))

(deftest scramble-test
  (testing "both args are empty"
    (is (scramble? "" "")))

  (testing "only str1 is empty"
    (is (not (scramble? "" "any"))))

  (testing "only str2 is empty"
    (is (scramble? "any" "")))

  (testing "true case"
    (is (scramble? "bab" "bb")))

  (testing "false case"
    (is (not (scramble? "ab" "aa")))))
