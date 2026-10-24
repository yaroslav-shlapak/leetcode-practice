package com.shlapak.yaroslav.leetcode.problems.p0278

class FirstBadVersionAlternative3: VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var r = n
        var l = 0
        while (r >= l) {
            val mid = l + (r - l) / 2
            val isBad = isBadVersion(mid)
            when {
                isBad && !isBadVersion(mid - 1) -> {
                    return mid
                }

                isBad -> {
                    r = mid - 1
                }

                !isBad -> {
                    l = mid + 1
                }
            }
        }
        return -1
    }
}

class FirstBadVersionAlternative2 : VersionControl() {
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

/**
 * LeetCode 278: First Bad Version.
 *
 * Finds the first bad version using the supplied version predicate.
 *
 * @see <a href="https://leetcode.com/problems/first-bad-version/">Problem statement</a>
 */
class FirstBadVersion : VersionControl() {
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
