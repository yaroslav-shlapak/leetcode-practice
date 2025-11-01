package com.shlapak.yaroslav.leetcode.problems1to100.problem34

/**
 * Created on 2019/05/31.
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

class FindFirstAndLastPositionOfElementInSortedArray_Optimized {
    class Solution {
        fun searchRange(nums: IntArray, target: Int): IntArray {
            //[5,7,7,7,7,7,7,7,7,8,8,10]
            val res = intArrayOf(-1, -1)

            res[0] = nums.search(target, false) { mid ->
                mid - 1 >= 0 && nums[mid] == nums[mid - 1]
            }
            if (res[0] == -1) return res
            res[1] = nums.search(target, true) { mid ->
                mid + 1 < nums.size && nums[mid] == nums[mid + 1]
            }

            return res
        }

        private fun IntArray.search(target: Int, isRight: Boolean, exitCondition: (Int) -> Boolean): Int {
            val nums = this
            var r = nums.size - 1
            var l = 0
            while (r >= l) {
                val mid = l + (r - l) / 2
                when {
                    nums[mid] > target -> r = mid - 1
                    nums[mid] < target -> l = mid + 1
                    else -> {
                        if (exitCondition(mid)) {
                            if (isRight) {
                                l = mid + 1
                            } else {
                                r = mid - 1
                            }
                        } else {
                            return mid
                        }
                    }
                }
            }
            return - 1
        }
    }
}
class FindFirstAndLastPositionOfElementInSortedArray {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val res = intArrayOf(-1, -1)

        res[0] = binarySearchLeft(nums, target, 0, nums.lastIndex)
        if (res[0] == -1) return res
        res[1] = binarySearchRight(nums, target, 0, nums.lastIndex)

        return res
    }

    private fun binarySearchRight(
        nums: IntArray,
        target: Int,
        start: Int,
        end: Int,
    ): Int {
        var r = end
        var l = start
        while (r >= l) {
            val mid = l + (r - l) / 2
            val rightNeighbor = mid + 1
            when {
                nums[mid] == target -> {
                    if (rightNeighbor < nums.size && nums[rightNeighbor] == target) {
                        l = rightNeighbor
                    } else {
                        return mid
                    }
                }

                nums[mid] < target -> {
                    l = mid + 1
                }

                nums[mid] > target -> {
                    r = mid - 1
                }


            }
        }
        return -1
    }

    private fun binarySearchLeft(
        nums: IntArray,
        target: Int,
        start: Int,
        end: Int,
    ): Int {
        var r = end
        var l = start
        while (r >= l) {
            val mid = l + (r - l) / 2
            val leftNeighbour = mid - 1
            when {
                nums[mid] == target -> {
                    if (leftNeighbour >= 0 && nums[leftNeighbour] == target) {
                        r = leftNeighbour
                    } else {
                        return mid
                    }
                }

                nums[mid] < target -> {
                    l = mid + 1
                }

                nums[mid] > target -> {
                    r = mid - 1
                }
            }
        }
        return -1
    }
}

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
        if (res[0] == -1) return res
        res[1] = binarySearchRightLeft(nums, target, res[0], nums.size - 1, false)

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