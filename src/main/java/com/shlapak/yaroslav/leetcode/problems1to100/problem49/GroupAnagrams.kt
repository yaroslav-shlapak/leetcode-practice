package com.shlapak.yaroslav.leetcode.problems1to100.problem49

/**
 * https://leetcode.com/problems/group-anagrams/
 *
 * Example 1:
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Example 2:
 *
 * Input: strs = [""]
 * Output: [[""]]
 * Example 3:
 *
 * Input: strs = ["a"]
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] consists of lowercase English letters.
 */
class GroupAnagrams {
    /**
     *  Given an array of strings strs, group the anagrams together.
     *  You can return the answer in any order.
     *
     *  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     *  typically using all the original letters exactly once.
     */
    class OptimalUsingCountAsKey {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {

            val res = mutableMapOf<String, MutableList<String>>()

            for (str in strs) {
                val key = str.toKey()
                val list = res[key]
                if (list != null) {
                    list.add(str)
                } else {
                    res[key] = mutableListOf(str)
                }
            }

            return res.map { (key, value) -> value }

        }

        private fun String.toKey(): String {
            val res = IntArray(26)
            for (c in this) {
                res[c - 'a']++
            }
            return res.joinToString(",")
        }
    }

    class OptimalUsingCountAsKey1 {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val res = mutableListOf<MutableList<String>>()
            val map = mutableMapOf<String, Int>()
            strs.forEach { s ->
                val key = getKey(s)
                val index = map[key]
                if (index != null) {
                    res[index].add(s)
                } else {
                    map[key] = res.size
                    res.add(mutableListOf(s))
                }
            }
            return res
        }

        private fun getKey(s: String): String {
            val letters = CharArray(26)
            for (c in s) {
                letters[c - 'a']++
            }
            val key = String(letters)
            return key
        }
    }

    class BruteForceMapAndSort {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val map = mutableMapOf<List<Char>, Int>()
            val result = mutableListOf<MutableList<String>>()
            strs.forEach { str ->
                val key = str.toList().sorted()
                val indexOfList = map[key]
                if (indexOfList != null) {
                    result[indexOfList].add(str)
                } else {
                    map[key] = result.size
                    result.add(mutableListOf(str))
                }
            }
            return result
        }
    }

    class BruteForceMapAndSort1 {
        fun groupAnagrams(strs: Array<String>): List<List<String>> {
            val result = mutableListOf<MutableList<String>>()
            val map = mutableMapOf<List<Char>, Int>()
            strs.asSequence().forEach { string ->
                val key = string.toCharArray().sorted()
                if (map.containsKey(key)) {
                    result[map[key]!!].add(string)
                } else {
                    map[key] = result.size
                    result.add(mutableListOf(string))
                }
            }

            return result
        }
    }

}
