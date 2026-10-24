package com.shlapak.yaroslav.leetcode.problems.p0946

/**
 * LeetCode 948: Bag of Tokens.
 *
 * Maximizes the score obtained by exchanging power and score through tokens.
 *
 * This source retains its historical package name, p0946.
 *
 * @see <a href="https://leetcode.com/problems/bag-of-tokens/">Problem statement</a>
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

                when {
                    // face up
                    pow >= tokens[l] -> {
                        pow -= tokens[l]
                        score++
                        maxScore = maxOf(maxScore, score)
                        l++
                    }
                    // face down
                    score >= 1 -> {
                        pow += tokens[r]
                        score--
                        r--
                    }
                    // no reason to continue
                    else -> {
                        break;
                    }
                }
            }

            return maxScore
        }
    }
}
