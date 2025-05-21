package com.shlapak.yaroslav.leetcode.problems201to300.problem208

import java.util.HashMap

/**
 * 208. Implement Trie (Prefix Tree)
 * https://leetcode.com/problems/implement-trie-prefix-tree/
 */
class TrieNode {
    val children = HashMap<Char, TrieNode>()
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