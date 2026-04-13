package com.shlapak.yaroslav.leetcode.problems901to1000.problem935

/**
 * 946. Bag of Tokens
 * https://leetcode.com/problems/bag-of-tokens/description/
 */

class BagOfTokens {
    class TwoPointers {
        fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
            tokens.sort()
            var l = 0
            var r = tokens.size - 1
            var pow = power
            var score = 0
            var maxScore = 0

            while (r >= l) {
                // face up
                when {
                    pow >= tokens[l] -> {
                        pow -= tokens[l]
                        score++
                        maxScore = maxOf(maxScore, score)
                        l++
                    }

                    score >= 1 -> {
                        pow += tokens[r]
                        score--
                        r--
                    }

                    else -> {
                        break;
                    }
                }
            }

            return maxScore
        }
    }
}