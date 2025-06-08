package com.shlapak.yaroslav.leetcode.problems1to100.problem88

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
class MergeSortedArrays {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val nums3 = IntArray(m)
        for (i in 0 until m) {
            nums3[i]= nums1[i]
        }
        var j = 0
        var k = 0
        for (i in 0 until m + n) {
            nums1[i] = when {
                j < m && k < n -> {
                    if (nums3[j] < nums2[k]) {
                        val temp = nums3[j]
                        j++
                        temp
                    } else {
                        val temp = nums2[k]
                        k++
                        temp
                    }
                }
                j < m -> {
                    val temp = nums3[j]
                    j++
                    temp
                }
                else -> {
                    val temp = nums2[k]
                    k++
                    temp
                }
            }
        }
    }

    fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var a1 = m - 1  // Pointer for the last element in the initial part of nums1
        var a2 = n - 1  // Pointer for the last element in nums2

        for (i in nums1.size - 1 downTo 0) {
            if (a1 >= 0 && (a2 < 0 || nums1[a1] >= nums2[a2])) {
                nums1[i] = nums1[a1]
                a1--
            } else {
                nums1[i] = nums2[a2]
                a2--
            }
        }
    }
}