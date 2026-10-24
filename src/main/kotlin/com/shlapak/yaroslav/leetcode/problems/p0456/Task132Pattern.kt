package com.shlapak.yaroslav.leetcode.problems.p0456

/**
 * LeetCode 456: 132 Pattern.
 *
 * Checks for a subsequence with the relative order 1, 3, 2.
 *
 * @see <a href="https://leetcode.com/problems/132-pattern/">Problem statement</a>
 */
class  Task132Pattern {
    class OptimalStack {
        fun find132pattern(nums: IntArray): Boolean {
            val stack = ArrayDeque<Int>()

            var middle = Int.MIN_VALUE

            for (index in nums.lastIndex downTo 0) {
                val num = nums[index]
                if (num < middle) {
                    return true
                }
                while(stack.isNotEmpty() && stack.last() < num) {
                    middle = stack.removeLast()
                }
                stack.addLast(num)
            }

            return false
        }
    }
}
