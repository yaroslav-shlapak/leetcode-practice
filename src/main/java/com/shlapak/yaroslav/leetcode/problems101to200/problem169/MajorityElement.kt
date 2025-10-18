package com.shlapak.yaroslav.leetcode.problems101to200.problem169

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -109 <= nums[i] <= 109
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
class MajorityElement {
    class ConstantSpace2 {
        fun majorityElement(nums: IntArray): Int {
            var maj = nums[0]
            var count = 1
            for (i in 1 until nums.size) {
                if (nums[i] == maj) {
                    count++
                } else {
                    count--
                }
                if (count == 0) {
                    maj = nums[i]
                    count = 1
                }
            }
            return maj
        }
    }

    class ConstantSpace {
        fun majorityElement(nums: IntArray): Int {
            var count = 0
            var candidate = nums[0]
            for (i in nums) {
                if (count == 0) {
                    candidate = i
                }
                if (i == candidate) {
                    count++
                } else {
                    count--
                }
            }
            return candidate
        }
    }

    class ConventionalSorting {
        fun majorityElement(nums: IntArray): Int {
            nums.sort()
            return nums[nums.size / 2]
        }
    }

    class MapCounting {
        fun majorityElement(nums: IntArray): Int {
            val map = mutableMapOf<Int, Int>()
            for (i in nums) {
                val value = map[i]
                if (value != null) {
                    val newValue = value + 1
                    if (newValue > nums.size / 2) {
                        return i
                    }
                    map[i] = newValue
                } else {
                    map[i] = 1
                }
            }
            return -1
        }
    }
}
