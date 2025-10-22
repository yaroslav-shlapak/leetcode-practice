package com.shlapak.yaroslav.leetcode.problems101to200.problem189

import kotlin.collections.reverse

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description/
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */

class RotateArray {
    class InPlaceReversal {
        fun rotate(nums: IntArray, k: Int): Unit {
            val n = nums.size
            val k = k % n
            nums.reverse(0, n - 1)
            nums.reverse(0, k - 1)
            nums.reverse(k, n - 1)
        }

        private fun IntArray.reverse(start: Int, end: Int) {
            var r = end
            var l = start
            while (r > l) {
                val temp = this[r]
                this[r] = this[l]
                this[l] = temp
                r--
                l++
            }
        }
    }

    class BruteForce {
        fun rotate(nums: IntArray, k: Int): Unit {
            val n = nums.size
            val k = k % n
            for (i in 0 until k) {
                val last = nums[n - 1]
                for (j in n - 1 downTo 1) {
                    nums[j] = nums[j - 1]
                }
                nums[0] = last
            }
        }
    }

    class ExtraSpace3 {
        fun rotate(nums: IntArray, k: Int): Unit {
            val k = k % nums.size
            val list = ArrayList<Int>(nums.size)
            for (i in nums.size - k until nums.size) {
                list.add(nums[i])
            }
            for (i in 0 until nums.size - k) {
                list.add(nums[i])
            }
            for (i in 0 until nums.size) {
                nums[i] = list[i]
            }
        }
    }

    class ExtraSpace2 {
        fun rotate(nums: IntArray, k: Int): Unit {
            val nums2 = IntArray(nums.size)
            val n = nums.size
            val k = k % n
            for (i in nums.indices) {
                nums2[(i + k) % n] = nums[i]
            }

            for (i in nums2.indices) {
                nums[i] = nums2[i]
            }
        }
    }

    class ExtraSpace {
        fun rotate(nums: IntArray, k: Int): Unit {
            val nums2 = IntArray(nums.size)
            val n = nums.size
            val k = k % n
            for (i in nums.indices) {
                nums2[i + k] = nums[i]
                if (i == n - 1 - k) {
                    break;
                }
            }
            var j = 0
            for (i in n - k until n) {
                nums2[j] = nums[i]
                j++
            }

            for (i in nums2.indices) {
                nums[i] = nums2[i]
            }
        }
    }
}