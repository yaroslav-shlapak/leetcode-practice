package com.shlapak.yaroslav.leetcode.problems101to200.problem121

/**
 * 121. Best Time to Buy and Sell Stock
 *
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock
 */
class BestTimeToBuyAndSellStocks {
    class DynamicProgramming {
        fun maxProfit(prices: IntArray): Int {
            var max = 0
            var min = Integer.MAX_VALUE
            for (i in 0 until prices.size) {
                min = minOf(prices[i], min)
                max = maxOf(prices[i] - min, max)
            }
            return max
        }
    }

    class TwoPointers {
        fun maxProfit(prices: IntArray): Int {
            var max = 0
            var l = 0
            for (r in 0 until prices.size) {
                if (prices[l] < prices[r]) {
                    max = maxOf(max, prices[r] - prices[l])
                } else {
                    l = r
                }
            }
            return max
        }
    }

    class BruteForce {
        fun maxProfit(prices: IntArray): Int {
            var max = 0
            for (i in 0 until prices.size) {
                for (j in i until prices.size) {
                    max = maxOf(max, prices[j] - prices[i])
                }
            }
            return max
        }
    }
}