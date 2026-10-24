package com.shlapak.yaroslav.leetcode.problems.p1011

import java.util.Collections
import java.util.PriorityQueue

/**
 * LeetCode 1011: Capacity to Ship Packages Within D Days.
 *
 * Finds the minimum shipping capacity that meets a day limit.
 *
 * @see <a href="https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/">Problem statement</a>
 */
class CapacityToShipPackagesWithinDDays {
    class BinarySearch {
        fun shipWithinDays(weights: IntArray, days: Int): Int {
            var r = weights.sum()
            var l = weights.max()
            var res = r

            fun fitsDays(shipSize: Int) : Boolean {
                var d = 1
                var remSize = shipSize
                for (w in weights) {
                    if (remSize - w < 0) {
                        remSize = shipSize
                        d++
                    }
                    remSize -= w
                }
                return d <= days
            }

            while (r >= l) {
                val shipSize = r - (r - l) / 2
                if (fitsDays(shipSize)) {
                    res = minOf(res, shipSize)
                    r = shipSize - 1
                } else {
                    l = shipSize + 1
                }
            }

            return res
        }
    }

    class BruteForce {
        fun shipWithinDays(weights: IntArray, days: Int): Int {
            var shipSize = weights.max()
            while (true) {
                var d = 1
                var remSize = shipSize
                for (w in weights) {
                    if (remSize - w < 0) {
                        remSize = shipSize
                        d++
                    }
                    remSize -= w
                }
                if (d <= days) {
                    return shipSize
                }
                shipSize++
            }
        }
    }
}
