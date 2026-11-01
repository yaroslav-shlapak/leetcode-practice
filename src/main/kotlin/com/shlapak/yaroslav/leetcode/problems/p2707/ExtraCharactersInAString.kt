package com.shlapak.yaroslav.leetcode.problems.p2707

/**
 * LeetCode 2707: Extra Characters in a String.
 *
 * Minimizes the characters left uncovered by non-overlapping dictionary words.
 *
 * @see <a href="https://leetcode.com/problems/extra-characters-in-a-string/">Problem statement</a>
 */
class ExtraCharactersInAString {
    /**
     * Computes the best result for each suffix, either leaving its first character extra
     * or matching a dictionary word there. Dictionary words can be reused.
     *
     * Time: O(n * L), where n is the string length and L is the total dictionary word length.
     * Space: O(n) for the suffix results.
     */
    class DynamicProgramming {
        fun minExtraChar(s: String, dictionary: Array<String>): Int {
            val extra = IntArray(s.length + 1)
            for (start in s.lastIndex downTo 0) {
                extra[start] = 1 + extra[start + 1]
                for (word in dictionary) {
                    if (s.startsWith(word, start)) {
                        extra[start] = minOf(extra[start], extra[start + word.length])
                    }
                }
            }
            return extra[0]
        }
    }

    /**
     * Uses a trie to find dictionary words beginning at each position while computing
     * the minimum extra characters in each suffix. Words contain lowercase English letters.
     *
     * Time: O(L + n * min(n, m)), where n is the string length, L is the total
     * dictionary word length, and m is the longest word length.
     * Space: O(L + n), including trie nodes and suffix results.
     */
    class Trie {
        private class Node {
            val children = arrayOfNulls<Node>(26)
            var isWord = false
        }

        fun minExtraChar(s: String, dictionary: Array<String>): Int {
            val root = Node()
            for (word in dictionary) {
                var node = root
                for (character in word) {
                    val index = character - 'a'
                    if (node.children[index] == null) node.children[index] = Node()
                    node = node.children[index]!!
                }
                node.isWord = true
            }

            val extra = IntArray(s.length + 1)
            for (start in s.lastIndex downTo 0) {
                extra[start] = 1 + extra[start + 1]
                var node = root
                for (end in start until s.length) {
                    node = node.children[s[end] - 'a'] ?: break
                    if (node.isWord) extra[start] = minOf(extra[start], extra[end + 1])
                }
            }
            return extra[0]
        }
    }
}

// TODO review
