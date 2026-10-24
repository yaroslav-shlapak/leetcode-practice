package com.shlapak.yaroslav.leetcode.problems.p1475

import java.util.Stack

/**
 * LeetCode 1475: Final Prices with a Special Discount in a Shop.
 *
 * Subtracts each price's first following price that is no greater.
 *
 * @see <a href="https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/">Problem statement</a>
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
