(ns scramble.core-test
  (:require [clojure.test :refer :all]
            [scramble.core :refer [scramble?]]))

(deftest scramble-test
  (testing "str1 is nil"
    (is (not (scramble? nil "a"))))

  (testing "str2 is nil"
    (is (not (scramble? "b" nil))))

  (testing "both args are empty"
    (is (scramble? "" "")))

  (testing "only str1 is empty"
    (is (not (scramble? "" "any"))))

  (testing "only str2 is empty"
    (is (scramble? "any" "")))

  (testing "true case"
    (is (scramble? "abcd" "bda")))

  (testing "false case"
    (is (not (scramble? "abcd" "aadb")))))
