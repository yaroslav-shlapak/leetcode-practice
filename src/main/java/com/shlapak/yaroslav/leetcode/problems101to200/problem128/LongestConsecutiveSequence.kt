package com.shlapak.yaroslav.leetcode.problems101to200.problem128

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 *
 * 128. Longest Consecutive Sequence
 *
 * Given an unsorted array of integers nums,
 * return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 * Example 3:
 *
 * Input: nums = [1,0,1,2]
 * Output: 3
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
class LongestConsecutiveSequence {
    class Optimal {
        fun longestConsecutive(nums: IntArray): Int {
            if (nums.isEmpty()) return 0
            // convert to set
            val set = nums.toSet()
            var res = 0
            // iterate over set elements
            for (i in set) {
                // check if item i has previous items
                if (!set.contains(i - 1)) {
                    var j = 0
                    // iterate until there are no next items in sequence
                    while (set.contains(i + j)) {
                        j++
                    }
                    // save maximum of two
                    res = maxOf(res, j)
                }
            }
            return res

        }
    }


}
class LongestConsecutiveSequence3 {
    fun longestConsecutive(nums: IntArray): Int {
        val mp = HashMap<Int, Int>()
        var res = 0

        for (num in nums) {
            if (mp[num] == null) {
                val left = mp[num - 1] ?: 0
                val right = mp[num + 1] ?: 0
                val sum = left + right + 1
                mp[num] = sum
                mp[num - left] = sum
                mp[num + right] = sum
                res = maxOf(res, sum)
            }
        }
        return res
    }
}


class LongestConsecutiveSequence2 {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val set = nums.toSet()
        var res = 0
        for (num in set) {
            // check if there is no left neighbour
            if (!set.contains(num - 1)) {
                var i = 0
                // iterate until we have sequence
                while (set.contains(num + i)) {
                    i++
                }
                res = maxOf(res, i)
            }
        }
        return res
    }
}

class LongestConsecutiveSequence4 {
    /**
     *  Given an unsorted array of integers nums,
     *  return the length of the longest consecutive elements sequence.
     *  You must write an algorithm that runs in O(n) time.
     */
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val set = nums.toSet()
        var max = 1
        for (i in set) {
            if (!set.contains(i - 1)) {
                var j = i
                var localMax = 1
                while (set.contains(j + 1)) {
                    localMax++
                    j++
                }
                if (localMax > max) {
                    max = localMax
                }
            }
        }
        return max
    }

    fun longestConsecutive2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val sorted = nums.sorted()
        var max = 1
        var localMax = 1
        for (i in 1 until sorted.size) {
            if (sorted[i - 1] == sorted[i]) continue
            if (sorted[i - 1] == sorted[i] - 1) {
                localMax++
            } else {
                localMax = 1
            }
            if (localMax > max) {
                max = localMax
            }
        }
        return max
    }
}