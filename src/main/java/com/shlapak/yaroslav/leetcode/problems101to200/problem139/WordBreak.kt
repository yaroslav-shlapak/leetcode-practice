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

/*
# Intuition
To check the whole string, I can see if it starts with any dictionary word. If it does, the problem shrinks to checking the rest of the string. Instead of passing new, smaller strings around (which can be slow), I can just use an index to point to where this "rest" begins in the original string. I'll probably end up trying to segment from the same index multiple times, so I should remember (cache) the results to save work.

## Time complexity:

* **`O(N)` factor:** Arises because the main computational logic (the `for` loop block) within `canSegmentFrom(startIndex)` is executed at most once for each of the $N$ possible starting indices of the string `s`, thanks to memoization.
* **`O(M)` factor:** Inside each non-memoized call to `canSegmentFrom`, the loop runs $M$ times (once for each word in `wordDict`).
* **`O(K)` factor:** Inside that loop, the `s.startsWith(word, startIndex)` operation takes time proportional to the length of the `word`. In the worst case, this is $O(K)$, where $K$ is the maximum word length in the dictionary.

So, the total time complexity is $O(N \cdot M \cdot K)$.
The space complexity is $O(N)$ for the `memo` map and $O(N)$ for the recursion call stack in the worst case (e.g., if `s` is "aaaaa" and `dict` is `["a"]`), making it $O(N)$ overall.

## Space complexity:
$$O(n)$$

# Code
```kotlin []
class Solution {
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val memo = mutableMapOf<Int, Boolean>()

        fun canSegmentFrom(startIndex: Int) : Boolean {
            if (startIndex == s.length) {
                return true
            }

            val isFound = memo[startIndex]
            if (isFound != null) return isFound

            for (i in 0 until wordDict.size) {
                val word = wordDict[i]
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
```
 */