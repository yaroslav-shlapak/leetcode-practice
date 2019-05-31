package com.shlapak.yaroslav.leetcode.problem34

/**
 * Created on 2019/05/31.
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
class Solution {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val res = intArrayOf(-1, -1)

        res[0] = binarySearchLeft(nums, target, 0, nums.size - 1)
        res[1] = binarySearchRight(nums, target, 0, nums.size - 1)

        return res
    }

    private fun binarySearchLeft(
            nums: IntArray,
            target: Int,
            from: Int,
            to: Int
    ): Int {
        var lo = from
        var hi = to
        var mid: Int
        while (hi >= lo) {
            mid = calcMid(hi, lo)
            val left = mid - 1
            when {
                nums[mid] == target -> {
                    if (left >= 0 && target == nums[left]) {
                        hi = left
                    } else {
                        return mid
                    }
                }
                nums[mid] < target -> {
                    lo = mid + 1
                }
                nums[mid] > target -> {
                    hi = mid - 1
                }
            }
        }
        return -1
    }

    private fun binarySearchRight(
            nums: IntArray,
            target: Int,
            from: Int,
            to: Int
    ): Int {
        var lo = from
        var hi = to
        var mid: Int
        while (hi >= lo) {
            mid = calcMid(hi, lo)
            val right = mid + 1
            when {
                nums[mid] == target -> {
                    if (right < nums.size && target == nums[right]) {
                        lo = right
                    } else {
                        return mid
                    }
                }
                nums[mid] < target -> {
                    lo = mid + 1
                }
                nums[mid] > target -> {
                    hi = mid - 1
                }
            }
        }
        return -1
    }

    private fun calcMid(hi: Int, lo: Int): Int {
        return lo + (hi - lo) / 2
    }
}

class Solution2 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val res = intArrayOf(-1, -1)
        nums.asSequence().forEachIndexed { index, num ->
            if (num == target) {
                if (res[0] == -1) {
                    res[0] = index
                }
                res[1] = index
            }
        }

        return res
    }
}

class Solution3 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val res = intArrayOf(-1, -1)

        res[0] = binarySearchRightLeft(nums, target, 0, nums.size - 1, true)
        res[1] = binarySearchRightLeft(nums, target, 0, nums.size - 1, false)

        return res
    }

    private fun binarySearchRightLeft(
            nums: IntArray,
            target: Int,
            from: Int,
            to: Int,
            isLeft: Boolean
    ): Int {
        var lo = from
        var hi = to
        var mid: Int
        while (hi >= lo) {
            mid = calcMid(hi, lo)

            when {
                nums[mid] == target -> {
                    val right = mid + 1
                    val left = mid - 1
                    if (isLeft) {
                        if (left >= 0 && target == nums[left]) {
                            hi = left
                        } else {
                            return mid
                        }
                    } else {
                        if (right < nums.size && target == nums[right]) {
                            lo = right
                        } else {
                            return mid
                        }
                    }
                }
                nums[mid] < target -> {
                    lo = mid + 1
                }
                nums[mid] > target -> {
                    hi = mid - 1
                }
            }
        }
        return -1
    }

    private fun calcMid(hi: Int, lo: Int): Int {
        return lo + (hi - lo) / 2
    }
}