package com.shlapak.yaroslav.leetcode.problems601to700.problem658


import java.util.PriorityQueue
import kotlin.math.abs

/**
 * 648. Replace Words
 * https://leetcode.com/problems/replace-words/
 */
class ReplaceWords {
    class Trie {
        fun replaceWords(dictionary: List<String>, sentence: String): String {
            val dict = Trie()
            for (s in dictionary) {
                dict.insert(s)
            }

            val res = StringBuilder()
            val l = sentence.split(' ')
            l.forEachIndexed { i, str ->
                res.append(dict.replace(str))
                if (i != l.size - 1) {
                    res.append(' ')
                }
            }

            return res.toString()
        }
    }

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

        fun replace(word: String): String {
            var cur = root
            val b = StringBuilder()
            for (i in 0 until word.length) {
                val ch = word[i]
                if (cur.endOfWord) {
                    return b.toString()
                }
                if (ch !in cur.children) {
                    break
                }
                b.append(ch)
                cur = cur.children[ch]!!
            }

            return word
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

