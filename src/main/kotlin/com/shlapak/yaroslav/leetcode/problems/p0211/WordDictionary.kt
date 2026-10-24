package com.shlapak.yaroslav.leetcode.problems.p0211

class TrieNode {
    val children = HashMap<Char, TrieNode>()
    var isWordEnd = false
}

/**
 * LeetCode 211: Design Add and Search Words Data Structure.
 *
 * Stores words and supports searches containing single-character wildcards.
 *
 * @see <a href="https://leetcode.com/problems/design-add-and-search-words-data-structure/">Problem statement</a>
 */
class WordDictionary() {
    private val root: TrieNode = TrieNode()

    fun addWord(word: String) {
        var cur = root
        for (c in word) {
            val node = cur.children[c]
            if (node == null) {
                val newNode = TrieNode()
                cur.children[c] = newNode
                cur = newNode
            } else {
                cur = node
            }
        }
        cur.isWordEnd = true
    }

    fun search(word: String): Boolean {

        fun dfs(node: TrieNode, j: Int): Boolean {
            var cur = node
            for (i in j until word.length) {
                val c = word[i]
                if (c == '.') {
                    for (node in cur.children.values) {
                        if (dfs(node, i + 1)) {
                            return true
                        }
                    }
                    return false
                } else {
                    val newNode = cur.children[c]
                    if (newNode == null) {
                        return false
                    } else {
                        cur = newNode
                    }
                }
            }
            return cur.isWordEnd

        }

        return dfs(root, 0)
    }

}
