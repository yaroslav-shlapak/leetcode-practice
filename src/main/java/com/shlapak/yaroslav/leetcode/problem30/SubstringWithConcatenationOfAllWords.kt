package com.shlapak.yaroslav.leetcode.problem30

import java.util.*

/**
 * Created on 2019/05/22.
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
class Solution {
    lateinit var w: Sequence<String>
    lateinit var res: MutableSet<Int>
    var size: Int = 0
    var totalLength = 0
    lateinit var stack: Stack<Pair<Int, MutableList<String>>>
    lateinit var searchable: String
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        init(s, words)
        if (size == 0) {
            return emptyList()
        }
        while (stack.isNotEmpty()) {
            val pair = stack.pop()
            //println("pair: $pair")
            search(pair)
        }
        return res.toList()
    }

    private fun init(s: String, words: Array<String>) {
        searchable = s
        w = words.asSequence()
        size = words.size
        totalLength = words.sumBy { it.length }
        res = mutableSetOf()
        stack = Stack()
        val list = w.toMutableList()
        for (i in 0 until searchable.length) {
            stack.add(i to list)
        }
    }

    private fun search(pair: Pair<Int, MutableList<String>>) {
        val (index, list) = pair
        if (list.isEmpty()) {
            val startIndex = index - totalLength
            //println("startIndex: $startIndex")
            res.add(startIndex)
            return
        }
        list.asSequence().forEachIndexed { i, word ->
            val lastIndex = index + word.length
            if (lastIndex <= searchable.length
                    && searchable.substring(index, lastIndex) == word) {
                val l = list.toMutableList()
                l.remove(word)
                stack.push(lastIndex to l)
            }
        }
    }
}
