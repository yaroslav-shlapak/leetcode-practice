package com.shlapak.yaroslav.leetcode.problem49

/**
 * Created on 2019/07/22.
 * https://leetcode.com/problems/group-anagrams/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 *
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
class Solution {
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