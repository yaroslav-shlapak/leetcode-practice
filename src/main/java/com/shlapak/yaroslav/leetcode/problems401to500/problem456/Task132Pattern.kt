package com.shlapak.yaroslav.leetcode.problems401to500.problem452

/**
 * 456. 132 Pattern
 * https://leetcode.com/problems/132-pattern/description/
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