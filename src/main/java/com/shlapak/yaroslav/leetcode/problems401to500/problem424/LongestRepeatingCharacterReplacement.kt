package com.shlapak.yaroslav.leetcode.problems401to500.problem424

/**
 * 424. Longest Repeating Character Replacement
 * https://leetcode.com/problems/longest-repeating-character-replacement/
 */
class LongestRepeatingCharacterReplacement {
    class MyAttempts {

        fun characterReplacement(s: String, k: Int): Int {
            var max = 0
            var maxIntervalCount = 0
            val counts = IntArray(26)
            var l = 0
            for (r in 0 until s.length) {
                val count = counts[s[r] - 'A'] + 1
                counts[s[r] - 'A'] = count
                maxIntervalCount = maxOf(maxIntervalCount, count)

                while (r - l + 1 - maxIntervalCount > k) {
                    counts[s[l] - 'A'] = counts[s[l] - 'A'] - 1
                    l++
                }

                max = maxOf(max, r - l + 1)
            }
            return max
        }

        fun characterReplacement3(s: String, k: Int): Int {
            var max = 0
            for (i in 0 until s.length) {
                val counts = IntArray(26)
                var maxIntervalCount = 0
                for (j in i until s.length) {
                    val count = counts[s[j] - 'A'] + 1
                    counts[s[j] - 'A'] = count
                    maxIntervalCount = maxOf(maxIntervalCount, count)
                    val intervalLen = j - i + 1
                    if (intervalLen - maxIntervalCount <= k) {
                        max = maxOf(max, intervalLen)
                    }
                }
            }
            return max
        }

        fun characterReplacement2(s: String, k: Int): Int {
            var max = 1
            for (i in 0 until s.length) {
                var rem = k
                var r = i + 1
                var l = i - 1
                //print("${s[i]} ")
                while (l >= 0 || r < s.length && rem > 0) {
                    if (s[r] != s[i]) {
                        rem--
                    }
                    if (s[l] != s[i]) {
                        rem--
                    }
                    if (r < s.length - 1) {
                        r++
                    }
                    if (l > 0) {
                        l--
                    }
                    //print("${s[i]} ")
                }
                //println()

                max = maxOf(r - l, max)
            }
            return max
        }
    }
}

class BruteForce {
    fun characterReplacement(s: String, k: Int): Int {
        var maxLength = 0
        for (i in s.indices) {
            for (j in i until s.length) {
                val substring = s.substring(i, j + 1)
                val maxCount = substring.groupingBy { it }.eachCount().maxOf { it.value }
                if (substring.length - maxCount <= k) {
                    maxLength = maxOf(maxLength, substring.length)
                }
            }
        }
        return maxLength
    }
}

class SlidingWindow {
    fun characterReplacement(s: String, k: Int): Int {
        val count = IntArray(26)
        var maxCount = 0
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            val index = s[right] - 'A'
            count[index]++
            maxCount = maxOf(maxCount, count[index])

            while (right - left + 1 - maxCount > k) {
                count[s[left] - 'A']--
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}

class SlidingWindowOptimized {
    fun characterReplacement(s: String, k: Int): Int {
        val count = IntArray(26)
        var maxCount = 0
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            val index = s[right] - 'A'
            count[index]++
            maxCount = maxOf(maxCount, count[index])

            if (right - left + 1 - maxCount > k) {
                count[s[left] - 'A']--
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}

class SlidingWindowWithMap {
    fun characterReplacement(s: String, k: Int): Int {
        val count = mutableMapOf<Char, Int>()
        var maxCount = 0
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            count[s[right]] = count.getOrDefault(s[right], 0) + 1
            maxCount = maxOf(maxCount, count[s[right]]!!)

            while (right - left + 1 - maxCount > k) {
                count[s[left]] = count[s[left]]!! - 1
                if (count[s[left]] == 0) {
                    count.remove(s[left])
                }
                left++
            }

            maxLength = maxOf(maxLength, right - left + 1)
        }

        return maxLength
    }
}
