package com.shlapak.yaroslav.leetcode.problems.p0169

/**
 * LeetCode 169: Majority Element.
 *
 * Finds the value occurring more than half the time.
 *
 * @see <a href="https://leetcode.com/problems/majority-element/">Problem statement</a>
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
