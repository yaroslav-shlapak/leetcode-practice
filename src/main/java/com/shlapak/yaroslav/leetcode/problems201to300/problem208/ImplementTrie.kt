package com.shlapak.yaroslav.leetcode.problems201to300.problem208

import java.util.HashMap

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class ImplementTrie {

    class Solution2 {
        class Trie() {
            private class TrieNode() {
                val children: MutableMap<Char, TrieNode> = mutableMapOf()
                var endOfWord: Boolean = false
            }
            private val root = TrieNode()

            fun insert(word: String) {
                var cur = root
                for (i in 0 until word.length) {
                    val ch = word[i]
                    if (ch !in cur.children) {
                        cur.children[ch] = TrieNode()
                    }
                    cur = cur.children[ch]!!
                }
                cur.endOfWord = true
            }

            fun search(word: String): Boolean {
                var cur = root
                for (i in 0 until word.length) {
                    val ch = word[i]
                    if (ch !in cur.children) {
                        return false
                    }
                    cur = cur.children[ch]!!
                }
                return cur.endOfWord
            }

            fun startsWith(prefix: String): Boolean {
                var cur = root
                for (i in 0 until prefix.length) {
                    val ch = prefix[i]
                    if (ch !in cur.children) {
                        return false
                    }
                    cur = cur.children[ch]!!
                }
                return true
            }

        }
    }

    class Solution1 {
        class TrieNode {
            val children = HashMap<Char, com.shlapak.yaroslav.leetcode.problems201to300.problem208.TrieNode>()
            var endOfWord = false
        }

        class Trie() {
            private val root = TrieNode()

            fun insert(word: String) {
                var cur = root
                for (c in word) {
                    val node = cur.children[c]
                    if (node == null) {
                        val newNode =  TrieNode()
                        cur.children[c] = newNode
                        cur = newNode
                    } else {
                        cur = node
                    }
                }
                cur.endOfWord = true
            }

            fun search(word: String): Boolean {
                var cur = root
                for (c in word) {
                    val node = cur.children[c]
                    if (node == null) {
                        return false
                    } else {
                        cur = node
                    }
                }
                return cur.endOfWord == true
            }

            fun startsWith(prefix: String): Boolean {
                var cur = root
                for (c in prefix) {
                    val node = cur.children[c]
                    if (node == null) {
                        return false
                    } else {
                        cur = node
                    }
                }
                return true
            }

        }
    }
}