package com.shlapak.yaroslav.leetcode.problems901to1000.problem977

import kotlin.math.min
import kotlin.math.sqrt

class SortedSquares {
    class Optimal {
        fun sortedSquares(nums: IntArray): IntArray {
            val n = nums.size
            val result = IntArray(n)
            var left = 0
            var right = n - 1
            var index = n - 1

            while (left <= right) {
                val leftSquare = nums[left] * nums[left]
                val rightSquare = nums[right] * nums[right]

                if (leftSquare > rightSquare) {
                    result[index] = leftSquare
                    left++
                } else {
                    result[index] = rightSquare
                    right--
                }
                index--
            }

            return result
        }
    }

    class OptimalMinSearch {
        fun sortedSquares(nums: IntArray): IntArray {
            var minIndex = -1
            var min = Int.MAX_VALUE
            for (i in 0 until nums.size) {
                nums[i] = nums[i] * nums[i]
                if (min > nums[i]) {
                    min = nums[i]
                    minIndex = i
                }
            }
            var r = minIndex + 1
            var l = minIndex
            val res = IntArray(nums.size)
            var i = 0
            // [16,1,0,9,100]
            // r = 4
            // l = -1
            // res = [0,1,9,16]
            // i = 4
            while (i < nums.size) {
                when {
                    r >= nums.size -> {
                        res[i] = nums[l]
                        l--
                    }
                    l < 0 -> {
                        res[i] = nums[r]
                        r++
                    }
                    nums[l] > nums[r] -> {
                        res[i] = nums[r]
                        r++
                    }
                    else -> {
                        res[i] = nums[l]
                        l--
                    }
                }
                i++
            }
            return res
        }
    }

    class OptimalTwoPointers {
        fun sortedSquares(nums: IntArray): IntArray {
            if (nums.isEmpty()) return nums
            val res = IntArray(nums.size)
            var l = 0
            var r = nums.size - 1
            var i = nums.size - 1

            while (r >= l) {
                val rNum = square(nums[r])
                val lNum = square(nums[l])

                if (rNum >= lNum) {
                    res[i] = rNum
                    i--
                    r--
                } else {
                    res[i] = lNum
                    i--
                    l++
                }
            }

            return res
        }

        private fun square(num: Int) = num * num
    }
    class SquaresOfSortedArray_BruteForce {
        fun sortedSquares(nums: IntArray): IntArray {
            return nums.map { it * it }.sorted().toIntArray()
        }
    }
}
