package com.shlapak.yaroslav.leetcode.problems1to100.problem17

/**
 * Created on 2019/04/23.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class Solution {

    private val pad = mapOf(
            2 to listOf("a", "b", "c"),
            3 to listOf("d", "e", "f"),
            4 to listOf("g", "h", "i"),
            5 to listOf("j", "k", "l"),
            6 to listOf("m", "n", "o"),
            7 to listOf("p", "q", "r", "s"),
            8 to listOf("t", "u", "v"),
            9 to listOf("w", "x", "y", "z")
    )

    private var res = mutableListOf("")

    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) {
            return emptyList()
        }
        digits
                .reversed()
                .asSequence()
                .filter { it.isDigit() }
                .map { it.toString().toInt() }
                .filter { pad.keys.contains(it) }
                .forEach { number ->
                    backtrack(pad[number] ?: error("no such key: $number"))
                }

        return res
    }

    private fun backtrack(prefixes: List<String>) {
        println("prefixes: $prefixes")
        val newRes = mutableListOf<String>()
        prefixes.asSequence().forEach { prefix ->
            res.asSequence().forEach { suffix ->
                newRes.add(prefix + suffix)
            }
        }

        res = newRes
    }
}