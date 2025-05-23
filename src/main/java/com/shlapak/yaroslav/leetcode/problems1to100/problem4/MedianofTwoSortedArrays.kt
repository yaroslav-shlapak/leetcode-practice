package com.shlapak.yaroslav.leetcode.problems1to100.problem4

/**
 * Created on 2019/04/08.
 */
class Solution {
    fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {
        val arr = nums1 + nums2
        arr.sort()

        val half = arr.size / 2
        val rem = arr.size % 2
        return if (rem == 0) {
            (arr[half] + arr[half - 1]).toDouble() / 2.0
        } else {
            arr[half].toDouble()
        }
    }

    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {
        val arr = IntArray(nums1.size + nums2.size)
        var i1 = 0
        var i2 = 0
        var i = 0
        while (i < arr.size) {
            if (nums1.getOrLast(i1) < nums2.getOrLast(i2)) {
                if (i1 < nums1.size) {
                    arr[i] = nums1.getOrLast(i1)
                    i1++
                } else {
                    arr[i] = nums2.getOrLast(i2)
                    i2++
                }
            } else {
                if (i2 < nums2.size) {
                    arr[i] = nums2.getOrLast(i2)
                    i2++
                } else {
                    arr[i] = nums1.getOrLast(i1)
                    i1++
                }
            }
            i++
        }
        val half = arr.size / 2
        val rem = arr.size % 2
        return if (rem == 0) {
            (arr[half] + arr[half - 1]).toDouble() / 2.0
        } else {
            arr[half].toDouble()
        }

    }

    private fun IntArray.getOrLast(index: Int): Int {
        return if (index < this.size) {
            this[index]
        } else {
            if (this.size == 0) {
                Int.MAX_VALUE
            } else {
                this[this.size - 1]
            }
        }
    }

    fun findMedianSortedArrays(A: IntArray, B: IntArray): Double {
        var A = A
        var B = B
        var m = A.size
        var n = B.size
        if (m > n) { // to ensure m<=n
            val temp = A
            A = B
            B = temp
            val tmp = m
            m = n
            n = tmp
        }
        var iMin = 0
        var iMax = m
        val halfLen = (m + n + 1) / 2
        while (iMin <= iMax) {
            val i = (iMin + iMax) / 2
            val j = halfLen - i
            if (i < iMax && B[j - 1] > A[i]) {
                iMin = i + 1 // i is too small
            } else if (i > iMin && A[i - 1] > B[j]) {
                iMax = i - 1 // i is too big
            } else { // i is perfect
                var maxLeft = 0
                if (i == 0) {
                    maxLeft = B[j - 1]
                } else if (j == 0) {
                    maxLeft = A[i - 1]
                } else {
                    maxLeft = Math.max(A[i - 1], B[j - 1])
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft.toDouble()
                }

                var minRight = 0
                if (i == m) {
                    minRight = B[j]
                } else if (j == n) {
                    minRight = A[i]
                } else {
                    minRight = Math.min(B[j], A[i])
                }

                return (maxLeft + minRight) / 2.0
            }
        }
        return 0.0
    }

}