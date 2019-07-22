package com.shlapak.yaroslav.leetcode.problem49

/**
 * Created on 2019/07/22.
 * https://leetcode.com/problems/group-anagrams/
 */
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val res = mutableListOf<MutableList<String>>()
        val map = mutableMapOf<List<Char>, Int>()
        strs.asSequence().forEach { string ->
            val key = string.toCharArray().sorted()
            if (map.containsKey(key)) {
                res[map[key]!!].add(string)
            } else {
                map.put(key, res.size)
                res.add(mutableListOf(string))
            }
        }

        return res
    }
}