package com.shlapak.yaroslav.leetcode.problems201to300.problem258

/**
 * 258. Add Digits
 * https://leetcode.com/problems/add-digits/
 */
class AddDigits {
    class Naive {
        fun addDigits(num: Int): Int {
            var n = num
            while (n >= 10) {
                var sum = 0
                while (n > 0) {
                    sum += n % 10
                    n /= 10
                }
                n = sum
            }
            return n
        }
    }

    class Math {
        fun addDigits(num: Int): Int {
            return if (num == 0) 0 else 1 + (num - 1) % 9
        }
    }

    class Recursive {
        fun addDigits(num: Int): Int {
            return if (num < 10) num else addDigits(num.toString().map { it - '0' }.sum())
        }
    }

    class Naive2 {
        fun addDigits(num: Int): Int {
            var res = num
            while (res / 10 > 0) {
                res = add(res)
            }
            return res
        }

        private fun add(num: Int): Int {
            var cur = num
            var sum = 0
            while (cur / 10 > 0) {
                sum += cur % 10
                cur = cur / 10
            }
            return sum + cur
        }
    }
}