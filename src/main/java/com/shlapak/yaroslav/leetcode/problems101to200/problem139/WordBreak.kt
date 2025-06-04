package com.shlapak.yaroslav.leetcode.problems101to200.problem139

/*
 * 139. Word Break
 * https://leetcode.com/problems/word-break/
 */
class WordBreak {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val memo = mutableMapOf<Int, Boolean>()

        fun canSegmentFrom(startIndex: Int): Boolean {
            // Base case: If startIndex reaches the end of 's', it's segmented.
            if (startIndex == s.length) {
                return true
            }

            val isFound = memo[startIndex]
            if (isFound != null) return isFound

            for (i in 0 until wordDict.size) {
                val word = wordDict[i]
                // Check if 's' (from 'startIndex') starts with 'word'.
                // Ensure the word fits within the remaining part of 's'.
                if (s.startsWith(word, startIndex)) {
                    if (canSegmentFrom(startIndex + word.length)) {
                        memo[startIndex] = true
                        return true
                    }
                }
            }
            memo[startIndex] = false
            return false
        }

        return canSegmentFrom(0)
    }

}