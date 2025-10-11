package com.shlapak.yaroslav.leetcode.problems301to400.problem324

import java.util.PriorityQueue

/**
 * 324. Wiggle Sort II
 * https://leetcode.com/problems/wiggle-sort-ii/
 */
class WiggleSort2 {

    class PriorityQueueApproach
    {
        fun wiggleSort(nums: IntArray) {
            // nums[0] < nums[1] > nums[2] < nums[3]
            val maxHeap = PriorityQueue<Int>(nums.size) { a, b -> b.compareTo(a) }
            for (i in 0 until nums.size) {
                maxHeap.offer(nums[i])
            }

            for (i in 1 until nums.size step 2 ) {
                nums[i] = maxHeap.poll()
            }
            for (i in 0 until nums.size step 2 ) {
                nums[i] = maxHeap.poll()
            }

        }
    }

    class SortingApproach {
        fun wiggleSort(nums: IntArray) {
            // nums[0] < nums[1] > nums[2] < nums[3]
            nums.sort()
            val sorted = nums.copyOf()
            var index = 1
            for (i in nums.size - 1 downTo 0 step 2) {
                nums[index] = sorted[i]
                index += 2
            }
            index = 0
            for (i in nums.size - 2 downTo 0 step 2) {
                nums[index] = sorted[i]
                index += 2
            }
        }
    }

    class CountingSortApproach {
        fun wiggleSort(nums: IntArray) {
            // nums[0] < nums[1] > nums[2] < nums[3]
            val count = IntArray(5001)
            for (num in nums) {
                count[num]++
            }
            var index = 1
            for (i in count.indices.reversed()) {
                while (count[i] > 0) {
                    nums[index] = i
                    index += 2
                    if (index >= nums.size) {
                        index = 0
                    }
                    count[i]--
                }
            }
        }
    }

    class DutchNationalFlagApproach {
        fun wiggleSort(nums: IntArray) {
            // nums[0] < nums[1] > nums[2] < nums[3]
            val n = nums.size
            val mid = findKthLargest(nums, (n + 1) / 2)
            val mid2 = findKthLargest(nums, n / 2)
            val temp = nums.copyOf()
            var left = 0
            var right = n - 1
            for (i in 0 until n) {
                if (temp[i] < mid) {
                    nums[left] = temp[i]
                    left += 2
                } else if (temp[i] > mid) {
                    nums[right] = temp[i]
                    right -= 2
                }
            }
            while (left < n) {
                nums[left] = mid2
                left += 2
            }
            while (right >= 0) {
                nums[right] = mid
                right -= 2
            }
        }

        private fun findKthLargest(nums: IntArray, k: Int): Int {
            var left = 0
            var right = nums.size - 1
            val target = nums.size - k

            while (left <= right) {
                val pivotIndex = partition(nums, left, right)
                when {
                    pivotIndex < target -> left = pivotIndex + 1
                    pivotIndex > target -> right = pivotIndex - 1
                    else -> return nums[pivotIndex]
                }
            }
            return -1
        }

        private fun partition(nums: IntArray, left: Int, right: Int): Int {
            val pivot = nums[right]
            var i = left
            for (j in left until right) {
                if (nums[j] <= pivot) {
                    nums.swap(i, j)
                    i++
                }
            }
            nums.swap(i, right)
            return i
        }

        private fun IntArray.swap(i: Int, j: Int) {
            val temp = this[i]
            this[i] = this[j]
            this[j] = temp
        }
    }

    class OptimalApproach {
        fun wiggleSort(nums: IntArray) {
            val n = nums.size
            val mid = findKthLargest(nums, (n + 1) / 2)
            val mid2 = findKthLargest(nums, n / 2)

            var left = 0
            var i = 0
            var right = n - 1

            fun newIndex(index: Int): Int {
                return (1 + 2 * index) % (n or 1)
            }

            while (i <= right) {
                when {
                    nums[newIndex(i)] > mid -> {
                        nums.swap(newIndex(left), newIndex(i))
                        left++
                        i++
                    }
                    nums[newIndex(i)] < mid -> {
                        nums.swap(newIndex(i), newIndex(right))
                        right--
                    }
                    else -> i++
                }
            }

            // Handle duplicates of median
            i = left
            right = n - 1
            while (i <= right) {
                when {
                    nums[newIndex(i)] > mid2 -> {
                        nums.swap(newIndex(left), newIndex(i))
                        left++
                        i++
                    }
                    nums[newIndex(i)] < mid2 -> {
                        nums.swap(newIndex(i), newIndex(right))
                        right--
                    }
                    else -> i++
                }
            }
        }

        private fun findKthLargest(nums: IntArray, k: Int): Int {
            var left = 0
            var right = nums.size - 1
            val target = nums.size - k

            while (left <= right) {
                val pivotIndex = partition(nums, left, right)
                when {
                    pivotIndex < target -> left = pivotIndex + 1
                    pivotIndex > target -> right = pivotIndex - 1
                    else -> return nums[pivotIndex]
                }
            }
            return -1
        }

        private fun partition(nums: IntArray, left: Int, right: Int): Int {
            val pivot = nums[right]
            var i = left
            for (j in left until right) {
                if (nums[j] <= pivot) {
                    nums.swap(i, j)
                    i++
                }
            }
            nums.swap(i, right)
            return i
        }

        private fun IntArray.swap(i: Int, j: Int) {
            val temp = this[i
}