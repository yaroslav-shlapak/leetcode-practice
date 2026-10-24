package com.shlapak.yaroslav.leetcode.problems.p2273

/**
 * LeetCode 2273: Find Resultant Array after Removing Anagrams.
 *
 * Removes adjacent anagrams until no further removal is possible.
 *
 * @see <a href="https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/">Problem statement</a>
 */
class FindResultantArrayAfterRemovingAnagrams {
    fun removeAnagrams(words: Array<String>): List<String> {
        val result = mutableListOf<String>()
        var i = 0
        var j = 1
        result.add(words[i])
        while (i < words.size && j < words.size) {

            while (j < words.size && isAnagram(words[i], words[j])) {
                j++
            }
            if (j < words.size) {
                result.add(words[j])
            } else {
                break
            }
            i = j
            j = i + 1
        }
        return result
    }

    private fun isAnagram(s: String, t: String): Boolean {
        val sortedS = s.toList().sorted()
        val sortedT = t.toList().sorted()

        return sortedS == sortedT
    }

    private fun isAnagram2(s: String, t: String): Boolean {
        val c = IntArray(26)
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
