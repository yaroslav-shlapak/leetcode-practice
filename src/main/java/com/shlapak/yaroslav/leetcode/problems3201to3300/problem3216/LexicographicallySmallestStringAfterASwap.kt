package com.shlapak.yaroslav.leetcode.problems3201to3300.problem3216

/**
 * 3216. Lexicographically Smallest String After a Swap
 * https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/
 */
class LexicographicallySmallestStringAfterASwap {
    class BruteForce {
        fun getSmallestString(s: String): String {
            var cand = StringBuilder(s)
            val save = StringBuilder(s)
            for (i in 0 until save.length - 1) {
                val temp1 = cand[i].toInt()
                val temp2 = cand[i + 1].toInt()
                if (temp2 < temp1 && temp1 % 2 == temp2 % 2) {
                    cand[i] = temp2.toChar()
                    cand[i + 1] = temp1.toChar()
                    return cand.toString()
                }

                cand = save
            }

            return save.toString()
        }
    }
}