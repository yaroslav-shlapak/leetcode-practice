package com.shlapak.yaroslav.leetcode.problems101to200.problem162

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 */
class FindPeakElement {
    class BruteForce {
        fun findPeakElement(nums: IntArray): Int {
            if (nums.size == 1) return 0
            if (nums.size == 2) return if (nums[0] > nums[1]) 0 else 1
            for (i in nums.indices) {
                if (
                    i > 0 && i < nums.size - 1 && nums[i - 1] < nums[i] && nums[i + 1] < nums[i]
                    || i == 0 && nums[i + 1] < nums[i]
                    || i == nums.size - 1 && nums[i - 1] < nums[i]
                ) {
                    return i
                }
            }
            return -1
        }
    }

    class Naive {
        fun findPeakElement(nums: IntArray): Int {
            for (i in 0 until nums.size - 1) {
                if (nums[i] > nums[i + 1]) {
                    return i
                }
            }
            return nums.size - 1
        }
    }

    class BinarySearch {
        fun findPeakElement(nums: IntArray): Int {
            var left = 0
            var right = nums.size - 1

            while (left < right) {
                val mid = left + (right - left) / 2
                if (nums[mid] > nums[mid + 1]) {
                    right = mid
                } else {
                    left = mid + 1
                }
            }

            return left
        }
    }

    class BinarySearch2 {
        fun findPeakElement(nums: IntArray): Int {
            var r = nums.size - 1
            var l = 0

            while (r >= l) {
                val mid = l + (r - l) / 2
                when {
                    mid > 0 && nums[mid] < nums[mid - 1]-> {
                        r = mid - 1
                    }

                    mid < nums.size - 1 && nums[mid] < nums[mid + 1] -> {
                        l = mid + 1
                    }

                    else -> {
                        return mid
                    }

                }
            }
            return l
        }
    }
}