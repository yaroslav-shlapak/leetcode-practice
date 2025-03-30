package com.shlapak.yaroslav.leetcode.problems201to300.problem278

/**
 * 278. First Bad Version
 * https://leetcode.com/problems/first-bad-version/description/
 */
class Solution2 : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var r = n
        var l = 1
        while (l < r) {
            val mid = l + (r - l) / 2
            if (isBadVersion(mid)) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l
    }
}

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var r = n
        var l = 0
        while (r >= l) {
            val mid = l + (r - l) / 2
            val midPrev = mid - 1
            println(mid)
            when {
                isBadVersion(mid) && !isBadVersion(midPrev) ->
                    return mid

                !isBadVersion(mid) -> l = mid
                isBadVersion(mid) -> r = mid - 1
            }
        }
        return -1
    }
}

open class VersionControl {
    open fun isBadVersion(n: Int): Boolean {
        return true
    }
    open fun firstBadVersion(n: Int): Int {
        return 0
    }
}