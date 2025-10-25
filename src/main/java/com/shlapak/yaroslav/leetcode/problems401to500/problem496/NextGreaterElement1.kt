package com.shlapak.yaroslav.leetcode.problems401to500.problem496

/**
 * 496. Next Greater Element I
 * https://leetcode.com/problems/next-greater-element-i/
 */
class NextGreaterElement1 {
    class StackAndMap {
        fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
            val map = mutableMapOf<Int, Int>()
            val stack = ArrayDeque<Int>()
            for (i in 0 until nums2.size) {
                map[nums2[i]] = -1
                while (stack.isNotEmpty() && stack.last() < nums2[i]) {
                    map[stack.removeLast()] = nums2[i]
                }
                stack.add(nums2[i])
            }
            val res = IntArray(nums1.size)
            for (i in 0 until nums1.size) {
                res[i] = map[nums1[i]]!!
            }

            return res

        }
    }

    class BruteForce {
        fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
            val res = IntArray(nums1.size) { -1 }
            for (i in nums1.indices) {
                val target = nums1[i]
                var found = false
                for (j in nums2.indices) {
                    if (nums2[j] == target) {
                        found = true
                    } else if (found && nums2[j] > target) {
                        res[i] = nums2[j]
                        break
                    }
                }
            }
            return res
        }
    }
}