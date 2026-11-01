package com.shlapak.yaroslav.leetcode.problems.p0720

/**
 * LeetCode 720: Longest Word in Dictionary.
 *
 * Finds the longest word buildable one character at a time from dictionary words,
 * choosing the lexicographically smallest when lengths tie.
 *
 * @see <a href="https://leetcode.com/problems/longest-word-in-dictionary/">Problem statement</a>
 */
class LongestWordInDictionary {
    /**
     * Processes a sorted copy so each prefix precedes its extensions. A word is
     * buildable if its immediate shorter prefix is already buildable.
     * The input is not modified.
     *
     * Time: O(n log n * m), where n is the number of words and m their maximum length.
     * Space: O(n * m), including the sorted copy, set, and temporary prefixes.
     */
    class SortingAndHashSet {
        fun longestWord(words: Array<String>): String {
            val buildable = hashSetOf("")
            var best = ""
            for (word in words.sorted()) {
                if (word.dropLast(1) in buildable) {
                    buildable.add(word)
                    if (word.length > best.length) best = word
                }
            }
            return best
        }
    }

    /**
     * Stores the words in a trie, then checks that every prefix ends at a word.
     * Assumes lowercase English letters and does not modify the input.
     *
     * Time: O(L), where L is the sum of word lengths.
     * Space: O(L) for trie nodes.
     */
    class Trie {
        private class Node {
            val children = arrayOfNulls<Node>(26)
            var isWord = false
        }

        fun longestWord(words: Array<String>): String {
            val root = Node()
            for (word in words) {
                var node = root
                for (character in word) {
                    val index = character - 'a'
                    if (node.children[index] == null) node.children[index] = Node()
                    node = node.children[index]!!
                }
                node.isWord = true
            }

            var best = ""
            for (word in words) {
                var node = root
                var buildable = true
                for (character in word) {
                    node = node.children[character - 'a']!!
                    if (!node.isWord) {
                        buildable = false
                        break
                    }
                }
                if (buildable && (word.length > best.length ||
                            (word.length == best.length && word < best))) {
                    best = word
                }
            }
            return best
        }
    }
}

// TODO review
