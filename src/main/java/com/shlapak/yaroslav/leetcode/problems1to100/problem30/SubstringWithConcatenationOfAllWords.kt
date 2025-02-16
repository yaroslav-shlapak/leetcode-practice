package com.shlapak.yaroslav.leetcode.problems1to100.problem30

import java.util.*


/**
 * Created on 2019/05/22.
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/
 */
class Solution {


    lateinit var counts: MutableMap<String, Int>
    lateinit var res: MutableList<Int>
    var inputStringLength = 0
    var numberOfWords = 0
    var wordLength = 0// same length
    lateinit var searchable: String

    fun findSubstring(s: String, words: Array<String>): List<Int> {
        if (init(words, s)) return res
        for (stringIndex in 0..inputStringLength - numberOfWords * wordLength) {
            search(stringIndex)
        }
        return res
    }

    private fun search(stringIndex: Int) {
        val seen = mutableMapOf<String, Int>()
        var countOfMatchedWords = 0
        while (countOfMatchedWords < numberOfWords) {
            val startIndex = stringIndex + countOfMatchedWords * wordLength
            val endIndex = stringIndex + (countOfMatchedWords + 1) * wordLength
            val word = searchable.substring(startIndex, endIndex)
            if (counts.containsKey(word)) {
                seen.put(word, seen.getOrDefault(word, 0) + 1)
                if (seen.getOrDefault(word, 0) > counts.getOrDefault(word, 0)) {
                    break
                }
            } else {
                break
            }
            countOfMatchedWords++
        }
        if (countOfMatchedWords == numberOfWords) {
            res.add(stringIndex)
        }
    }

    private fun init(words: Array<String>, s: String): Boolean {
        res = mutableListOf()
        numberOfWords = words.size
        if (numberOfWords == 0) {
            return true
        }
        searchable = s
        counts = mutableMapOf()
        for (word in words) {
            counts[word] = counts.getOrDefault(word, 0) + 1
        }
        inputStringLength = s.length
        wordLength = words[0].length // same length
        return false
    }

}

class Solution2 {

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
