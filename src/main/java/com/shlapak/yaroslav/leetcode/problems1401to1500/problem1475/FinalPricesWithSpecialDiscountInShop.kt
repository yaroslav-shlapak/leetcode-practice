package com.shlapak.yaroslav.leetcode.problems1401to1500.problem1475

import java.util.Stack

/**
 * 1475. Final Prices With a Special Discount in a Shop
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop
 */
class FinalPricesWithSpecialDiscountInShop {
    fun finalPrices(prices: IntArray): IntArray {
        // [5, 1, 6, 2]
        val stack = Stack<Pair<Int, Int>>()
        val res = IntArray(prices.size)
        for (i in prices.indices) {
            res[i] = prices[i]
            while (!stack.isEmpty() && stack.peek().first >= prices[i]) {
                val (price, index) = stack.pop()
                res[index] = price - prices[i]
            }
            stack.push(prices[i] to i)
        }

        return res
    }
}