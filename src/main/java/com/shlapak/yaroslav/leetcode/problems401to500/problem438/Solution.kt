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
    class OptimalSlidingWindowWithComments {
        fun findAnagrams(s: String, p: String): List<Int> {
            if (s.length < p.length) {
                return emptyList()
            }

            // Use IntArrays as frequency maps for performance. 'a' is index 0, 'b' is 1, etc.
            val pMap = IntArray(26)
            val sMap = IntArray(26)

            // 1. Initialize the maps for the pattern and the first window of s
            for (i in p.indices) {
                pMap[p[i] - 'a']++
                sMap[s[i] - 'a']++
            }

            val result = mutableListOf<Int>()

            // 2. Check if the first window is an anagram
            if (pMap.contentEquals(sMap)) {
                result.add(0)
            }

            // 3. Slide the window across the rest of s
            for (i in p.length until s.length) {
                // Add the new character entering the window from the right
                sMap[s[i] - 'a']++

                // Remove the old character leaving the window from the left
                val oldCharIndex = s[i - p.length] - 'a'
                sMap[oldCharIndex]--

                // 4. Check if the current window is an anagram
                if (pMap.contentEquals(sMap)) {
                    // The starting index of this window is (i - p.length + 1)
                    result.add(i - p.length + 1)
                }
            }

            return result
        }
    }

    class OptimalSlidingWindow {
        fun findAnagrams(s: String, p: String): List<Int> {
            val result = mutableListOf<Int>()
            val pLen = p.length
            if (s.length < pLen) return result

            val sCount = IntArray(26)
            val pCount = IntArray(26)

            for (i in 0 until pLen) {
                sCount[s[i] - 'a']++
                pCount[p[i] - 'a']++
            }

            if (sCount.contentEquals(pCount)) {
                result.add(0)
            }

            for (i in pLen until s.length) {
                sCount[s[i] - 'a']++
                sCount[s[i - pLen] - 'a']--

                if (sCount.contentEquals(pCount)) {
                    result.add(i - pLen + 1)
                }
            }

            return result
        }
    }

    class OptimalMapSlidingWindow {
        fun findAnagrams(s: String, p: String): List<Int> {
            val result = mutableListOf<Int>()
            val pLen = p.length
            if (s.length < pLen) return result

            val pMap = mutableMapOf<Char, Int>()
            val sMap = mutableMapOf<Char, Int>()

            for (c in p) {
                pMap[c] = pMap.getOrDefault(c, 0) + 1
            }

            for (i in 0 until pLen) {
                val c = s[i]
                sMap[c] = sMap.getOrDefault(c, 0) + 1
            }

            if (sMap == pMap) {
                result.add(0)
            }

            for (i in pLen until s.length) {
                val newChar = s[i]
                sMap[newChar] = sMap.getOrDefault(newChar, 0) + 1

                val oldChar = s[i - pLen]
                if (sMap[oldChar] == 1) {
                    sMap.remove(oldChar)
                } else {
                    sMap[oldChar] = sMap[oldChar]!! - 1
                }

                if (sMap == pMap) {
                    result.add(i - pLen + 1)
                }
            }

            return result
        }
    }

    class OptimalMapSlidingWindow2 {
        fun findAnagrams(s: String, p: String): List<Int> {
            if (s.length < p.length) return emptyList()
            val result = mutableListOf<Int>()
            //s = "cbaebabacd"
            //p = "abc"
            val sMap = mutableMapOf<Char, Int>()
            val pMap = mutableMapOf<Char, Int>()

            for (c in p) {
                val count = pMap.getOrDefault(c, 0)
                pMap[c] = count + 1
            }

            for (i in 0 until p.length) {
                val c = s[i]
                val count = sMap.getOrDefault(c, 0)
                sMap[c] = count + 1
            }

            if (pMap == sMap) {
                result.add(0)
            }

            for (i in p.length until s.length) {
                val c = s[i]
                val count = sMap.getOrDefault(c, 0)
                sMap[c] = count + 1

                val oldC = s[i - p.length]
                val oldVal = sMap[oldC]
                when {
                    oldVal == null -> {
                        // do nothing
                    }

                    oldVal == 1 -> sMap.remove(oldC)
                    oldVal > 1 ->
                        sMap[oldC] = oldVal - 1
                }

                if (sMap == pMap) {
                    result.add(i - p.length + 1)
                }
            }


            return result
        }
    }
}

class OptimalSlidingWindow2 {
    fun findAnagrams(s: String, p: String): List<Int> {
        val res = mutableListOf<Int>()
        val n = s.length
        val m = p.length
        val golden = IntArray(26)
        for (i in 0..n - m) {
            for (j in 0 until m) {
                golden[s[i + j] - 'a']++
                golden[p[j] - 'a']--
            }
            var found = true
            for (j in golden.indices) {
                if (golden[j] != 0) {
                    found = false
                    golden[j] = 0
                    break
                } else {
                    golden[j] = 0
                }
            }
            if (found) {
                res.add(i)
            }
        }
        return res
    }
}

class OptimalFrequencyArray {

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
}

class FastFrequencyArray {

    fun findAnagrams(s: String, p: String): List<Int> {
        val result = mutableListOf<Int>()
        val pLen = p.length
        val pMap = IntArray(26)
        for (c in p) {
            pMap[c - 'a'] += 1
        }
        for (i in 0..s.length - pLen) {
            if (isAnagram(s.substring(i, i + pLen), pMap)) {
                result.add(i)
            }
        }
        return result
    }

    private fun isAnagram(s: String, pMap: IntArray): Boolean {
        val c = IntArray(26)
        for (s in s) {
            c[s - 'a'] += 1
        }

        for (s in s) {
            if (c[s - 'a'] != pMap[s - 'a']) return false
        }
        return true
    }
}

class MapBruteForce {
    fun findAnagrams(s: String, p: String): List<Int> {
        val res = mutableListOf<Int>()
        val map = p.countToMap()
        for (i in 0 until s.length - p.length + 1) {
            if (s.substring(i, i + p.length).countToMap() == map) {
                res.add(i)
            }
        }
        return res
    }

    private fun String.countToMap(): Map<Char, Int> {
        return groupingBy { it }.eachCount()
    }
}

class MapBruteForceLong {
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
}