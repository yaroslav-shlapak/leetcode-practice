package com.shlapak.yaroslav.leetcode.problems1to100.problem17

/**
 * Created on 2019/04/23.
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
class LetterCombinationsOfAPhoneNumberRecursive {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val numberToChar = mutableMapOf(
            2 to "abc",
            3 to "def",
            4 to "ghi",
            5 to "jkl",
            6 to "mno",
            7 to "pqrs",
            8 to "tuv",
            9 to "wxyz"
        )
        val res = mutableListOf<String>()

        // digits = "23"
        // 1: index = 0, cur = "" => code = "abc" => cur + c = "" + "a" ... => backtrack(1, [a, b, c])
        // 2: index = 1, cur = [a, b, c] => code = "def" => cur + c = a + d, a + e, a + f, b + d, ...., cf => backtrack(1, [ad, ae, ..., cf])
        // 3: index = 2 => cur.len == digigs.len => res.add([ad, ae, ..., cf])
        fun backtrack(index: Int, cur: String) {
            if (cur.length == digits.length) {
                res.add(cur)
                return
            }
            val code = numberToChar[digits[index].digitToInt()]!!
            for (c in code) {
                backtrack(index + 1, cur + c)
            }
        }

        backtrack(0, "")
        return res
    }
}

class LetterCombinationsOfAPhoneNumberIterative {
    fun letterCombinations(digits: String): List<String> {
        if (digits.isEmpty()) return emptyList()
        val numberToChar = mutableMapOf(
            2 to "abc",
            3 to "def",
            4 to "ghi",
            5 to "jkl",
            6 to "mno",
            7 to "pqrs",
            8 to "tuv",
            9 to "wxyz"
        )
        var res: MutableList<String> = MutableList<String>(1) { "" }
        for (num in digits) {
            res = addNumbers(res, numberToChar[num.digitToInt()]!!)
        }
        return res
    }

    // 1: 4
    // 2: 4 * 4 = 16
    // 16: 16 * 4 = 64
    // 64: 64 * 4 = 256

    // for every base element add each toAdd char
    // 1: ["","",""] * ["abc"] =>["a","b","c"]
    // 2: ["a","b","c"] * "pqrs" => ["ap", "aq", "ar", "as", "bp", "bq", "br", "bs", "cp", "cq", "cr", "cs"]
    fun addNumbers(base: MutableList<String>, toAdd: String): MutableList<String> {
        val res = mutableListOf<String>()
        for (str in base) {
            for (add in toAdd) {
                res.add(str + add)
            }
        }
        return res
    }
}

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