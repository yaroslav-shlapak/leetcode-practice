package com.shlapak.yaroslav.leetcode.problems2001to2100.problem2062

class CountVowelSubstrings {
    class BruteForce {
        fun countVowelSubstrings(word: String): Int {
            val set = setOf('a', 'e', 'i', 'o', 'u')
            var count = 0
            for (i in 0 until word.length) {
                val map = mutableSetOf<Char>()
                var j = i
                while (j < word.length && set.contains(word[j])) {
                    map.add(word[j])
                    if (map.size >= set.size) {
                        count++
                    }
                    j++
                }
            }
            return count
        }
    }
}