package com.shlapak.yaroslav.leetcode.problem33

/**
 * Created on 2019/05/29.
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var hi = nums.size - 1
        var lo = 0
        var mid: Int
        while (hi >= lo) {
            mid = calcMid(hi, lo)
            when {
                target == nums[mid] -> {
                    return mid
                }
                //if low part is monotonically increasing, or the pivot point is in the high part
                nums[mid] >= nums[lo] -> {
                    //must use ">=" at here since we need to make sure the target is in the low part,
                    //then safely drop the high part
                    if (target >= nums[lo] && target < nums[mid]) {
                        hi = mid - 1
                    } else {
                        lo = mid + 1
                    }
                }
                //if high part is monotonically increasing, or the pivot point is in the low part
                else -> {
                    //must use "<=" at here since we need to make sure the target is in the high part,
                    //then safely drop the low part
                    if (target <= nums[hi] && target > nums[mid]) {
                        lo = mid + 1
                    } else {
                        hi = mid - 1
                    }
                }

            }
        }
        return -1
    }
}

class Solution2 {
    fun search(nums: IntArray, target: Int): Int {
        // lo==hi is the index of the smallest value and also the number of places rotated.
        val rot = findRotationIndex(nums)
        var lo = 0
        var hi = nums.size - 1
        // The usual binary search and accounting for rotation.
        while (lo <= hi) {
            val mid = calcMid(hi, lo)
            /*
            If we want to find realmid for array [4,5,6,7,0,1,2],
            you can shift the part before the rotating point to the end of the array (after 2)
            so that the sorted array is "recovered" from the rotating point but only longer,
            like this: [4, 5, 6, 7, 0, 1, 2, 4, 5, 6, 7].
            The real mid in this longer array is the middle point between the rotating point
            and the last element: (rot + (hi+rot)) / 2. (hi + rot) is the index of the last element.
            And of course, this result is larger than the real middle.
            So you just need to wrap around and get the remainder:
            ((rot + (hi + rot)) / 2) % n. And this expression is effectively (rot + hi/2) % n,
            which is (rot+mid) % n.
             */
            val realMid = (mid + rot) % nums.size
            when {
                nums[realMid] == target -> {
                    return realMid
                }
                nums[realMid] < target -> {
                    lo = mid + 1
                }
                else -> {
                    hi = mid - 1
                }
            }
        }
        return -1
    }

    private fun findRotationIndex(nums: IntArray): Int {
        var lo = 0
        var hi = nums.size - 1
        // find the index of the smallest value using binary search.
        // Loop will terminate since mid < hi, and lo or hi will shrink by at least 1.
        // Proof by contradiction that mid < hi: if mid==hi, then lo==hi and loop would have been terminated.
        while (lo < hi) {
            val mid = calcMid(hi, lo)
            if (nums[mid] > nums[hi]) {
                lo = mid + 1
            } else {
                hi = mid
            }
        }
        return lo
    }
}

private fun calcMid(hi: Int, lo: Int) = lo + (hi - lo) / 2