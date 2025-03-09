package com.shlapak.yaroslav.leetcode.problems401to500.problem438

/**
 *
 * 438. Find All Anagrams in a String
 *
 * https://leetcode.com/problems/find-all-anagrams-in-a-string/
 *
 *
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
 * You may return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 *
 * Example 1:
 *
 * Input: s = "cbaebabacd", p = "abc"
 * Output: [0,6]
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *
 * Input: s = "abab", p = "ab"
 * Output: [0,1,2]
 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 *
 * Constraints:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s and p consist of lowercase English letters.
 */
class FindAllAnagramsInString {
    fun findAnagrams(s: String, p: String): List<Int> {
        val sl = s.toList()
        val pl = p.toList().sorted()
        val result = mutableListOf<Int>()
        val pLen = pl.size
        for (i in 0..s.length - pLen) {
            if (sl.subList(i, i + pLen).sorted() == pl) {
                result.add(i)
            }
        }
        return result
    }
}

class FindAllAnagramsInString2 {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pLen = p.length
        for (i in 0..s.length - pLen) {
            if (isAnagram(s.substring(i, i + pLen), p)) {
                result.add(i)
            }
        }
        return result
    }

    private fun isAnagram(s1: String, s2: String): Boolean {
        val c = IntArray(26)
        for (s in s1) {
            c[s - 'a'] += 1
        }
        for (s in s2) {
            c[s - 'a'] -= 1
        }
        for (s in c) {
            if (s != 0) return false
        }
        return true
    }
}

class FindAllAnagramsInString3 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pLen = p.length
        val pMap = prepareMap(p)
        for (i in 0..s.length - pLen) {
            if (isAnagram(s.substring(i, i + pLen), pMap)) {
                result.add(i)
            }
        }
        return result
    }

    private fun isAnagram(s: String, pMap: MutableMap<Char, Int>): Boolean {
        val sMap = prepareMap(s)
        for (c in s) {
            if (sMap[c] != pMap[c]) {
                return false
            }
        }
        return true
    }

    private fun prepareMap(s: String): MutableMap<Char, Int> {
        val pMap = mutableMapOf<Char, Int>()
        for (c in s) {
            val v = pMap[c]
            if (v != null) {
                pMap[c] = v + 1
            } else {
                pMap[c] = 1
            }
        }
        return pMap
    }
}


class FindAllAnagramsInString4 {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pLen = p.length
        val pMap = IntArray(26)
        for (c in p) {
            pMap[c - 'a'] += 1
        }
        for (i in 0..s.length - pLen) {
            if (isAnagram2(s.substring(i, i + pLen), pMap)) {
                result.add(i)
            }
        }
        return result
    }

    private fun isAnagram2(s1: String, pMap: IntArray): Boolean {
        val c = IntArray(26)
        for (s in s1) {
            c[s - 'a'] += 1
        }

        for (s in s1) {
            if (c[s - 'a'] != pMap[s - 'a']) return false
        }
        return true
    }
}

class Solution {
    fun findAnagrams2(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()

        for (i in 0..s.length - p.length) {
            if (isAnagram(s.substring(i, i + p.length), p)) {
                result.add(i)
            }
        }

        return result
    }

    fun findAnagrams(s: String, p: String): List<Int> {

        if (p.length > s.length) return listOf()

        val result = mutableListOf<Int>()

        val numberOfLetters = 26
        val sFreq = IntArray(numberOfLetters)
        val pFreq = IntArray(numberOfLetters)

        for (i in p.indices) {
            sFreq[s[i] - 'a']++
            pFreq[p[i] - 'a']++
        }

        if (sFreq.contentEquals(pFreq)) result.add(0)

        for (i in 0 until s.length - p.length) {

            //Sliding window (size p.length)
            sFreq[s[i] - 'a']--
            sFreq[s[i + p.length] - 'a']++

            if (sFreq.contentEquals(pFreq)) result.add(i + 1)
        }

        return result
    }

    fun isAnagram(s: String, t: String): Boolean {
        val numberOfLetters = 26
        val c = IntArray(numberOfLetters)
        for (l in s) {
            c[l - 'a']++;
        }
        for (l in t) {
            c[l - 'a']--;
        }
        for (i in c) {
            if (i != 0) return false
        }
        return true
    }
}