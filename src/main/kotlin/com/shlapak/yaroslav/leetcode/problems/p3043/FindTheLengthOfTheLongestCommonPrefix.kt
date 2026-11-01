package com.shlapak.yaroslav.leetcode.problems.p3043

/**
 * LeetCode 3043: Find the Length of the Longest Common Prefix.
 *
 * Finds the longest decimal prefix shared by a number from each input array.
 *
 * @see <a href="https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/">Problem statement</a>
 */
class FindTheLengthOfTheLongestCommonPrefix {
    /**
     * Stores the decimal digits of the first array in a trie with ten children per node.
     * Walking each number from the second array counts matching leading digits until an
     * edge is missing. Every visited node represents a prefix, so terminal markers are unnecessary.
     * Requires positive integers. Neither input is modified; trie state is local to each call.
     *
     * Time: O((n + m) * D), for array lengths n and m and at most D digits per number.
     * Space: O(n * D), including trie nodes and temporary digit strings.
     */
    class Trie {
        private class Node {
            val children = arrayOfNulls<Node>(10)
        }

        fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
            val root = Node()
            for (number in arr1) {
                var node = root
                for (digit in number.toString()) {
                    val index = digit - '0'
                    val child = node.children[index] ?: Node().also { node.children[index] = it }
                    node = child
                }
            }

            var longest = 0
            for (number in arr2) {
                var node = root
                var length = 0
                for (digit in number.toString()) {
                    node = node.children[digit - '0'] ?: break
                    length++
                }
                longest = maxOf(longest, length)
            }
            return longest
        }
    }

    /**
     * Stores all prefixes from [arr1], removing trailing digits with integer division.
     * For each number in [arr2], the first matching prefix is its longest match.
     * Requires positive integers. Neither input is modified.
     *
     * Time: O((n + m) * D) expected, for array lengths n and m and at most D digits per number.
     * Space: O(n * D) for the distinct numeric prefixes.
     */
    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val prefixes = mutableSetOf<Int>()
        for (number in arr1) {
            var prefix = number
            while (prefix > 0) {
                prefixes.add(prefix)
                prefix /= 10
            }
        }

        var longest = 0
        for (number in arr2) {
            var prefix = number
            while (prefix > 0 && prefix !in prefixes) prefix /= 10
            var length = 0
            while (prefix > 0) {
                length++
                prefix /= 10
            }
            longest = maxOf(longest, length)
        }
        return longest
    }
}

// TODO review
