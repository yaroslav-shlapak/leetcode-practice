package com.shlapak.yaroslav.leetcode.problems.p0677

/**
 * LeetCode 677: Map Sum Pairs.
 *
 * @see <a href="https://leetcode.com/problems/map-sum-pairs/">Problem statement</a>
 */
class MapSum : MapSumOperations by Trie() {
    /** Stores keys directly and scans them for each query. */
    class Scan : MapSumOperations {
        private val values = mutableMapOf<String, Int>()

        override fun insert(key: String, value: Int) {
            values[key] = value
        }

        override fun sum(prefix: String): Int =
            values.entries.sumOf { (key, value) -> if (key.startsWith(prefix)) value else 0 }
    }

    /** Stores the total for every prefix and adjusts it when a key changes. */
    class PrefixSums : MapSumOperations {
        private val values = mutableMapOf<String, Int>()
        private val sums = mutableMapOf<String, Int>()

        override fun insert(key: String, value: Int) {
            val difference = value - (values[key] ?: 0)
            values[key] = value
            for (length in 0..key.length) {
                val prefix = key.substring(0, length)
                sums[prefix] = (sums[prefix] ?: 0) + difference
            }
        }

        override fun sum(prefix: String): Int = sums[prefix] ?: 0
    }

    /** Shares prefix storage in a trie, with a running total at each node. */
    class Trie : MapSumOperations {
        private class Node {
            val children = mutableMapOf<Char, Node>()
            var sum = 0
        }

        private val root = Node()
        private val values = mutableMapOf<String, Int>()

        override fun insert(key: String, value: Int) {
            val difference = value - (values[key] ?: 0)
            values[key] = value

            var node = root
            node.sum += difference
            for (character in key) {
                node = node.children.getOrPut(character) { Node() }
                node.sum += difference
            }
        }

        override fun sum(prefix: String): Int {
            var node = root
            for (character in prefix) {
                node = node.children[character] ?: return 0
            }
            return node.sum
        }
    }
}

interface MapSumOperations {
    fun insert(key: String, value: Int)
    fun sum(prefix: String): Int
}
