package com.shlapak.yaroslav.leetcode.problems701to800

import kotlin.math.min


/**
 * 702. Search in a Sorted Array of Unknown Size
 * https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/editorial/
 */
class SearchinaSortedArrayofUnknownSize {
    fun search(arr: List<Int>, target: Int): Int {
        if (arr.isEmpty()) {
            return -1
        }

        var left = 0
        var right = 1

        // Exponentially increase the search range.
        while (right < arr.size && arr[right] < target) {
            left = right + 1

            // Prevent integer overflow.
            if (right > arr.size / 2) {
                right = arr.lastIndex
                break
            }

            right *= 2
        }

        right = minOf(right, arr.lastIndex)

        // Standard binary search.
        while (left <= right) {
            val mid = left + (right - left) / 2
            val value = arr[mid]

            when {
                value == target -> return mid
                value < target -> left = mid + 1
                else -> right = mid - 1
            }
        }

        return -1
    }
}