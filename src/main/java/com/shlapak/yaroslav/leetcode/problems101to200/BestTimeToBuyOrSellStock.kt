package com.shlapak.yaroslav.leetcode.problems101to200

/*
121. Best Time to Buy and Sell Stock
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
 */
class BestTimeToBuyOrSellStock {
    fun maxProfit(prices: IntArray): Int {
        var res = 0
        var startingPoint = prices[0]
        for (price in prices) {
            startingPoint = minOf(startingPoint, price)
            val profit = price - startingPoint
            res = maxOf(res, profit)
        }
        return res
    }

    fun maxProfit2(prices: IntArray): Int {
        var res = 0
        var min = prices[0]
        var max = prices[0]
        var i = 1
        var j = 1
        while (i < prices.size && j < prices.size) {
            if (prices[j] < min) {
                min = prices[j]
                max = prices[j]
                i = j
            }
            if (prices[j] > max) {
                max = prices[j]
            }
            j++
            res = maxOf(res, max - min)
        }
        return res
    }
}