package com.shlapak.yaroslav.leetcode.problems1001to1100.problem1011

import java.util.Collections
import java.util.PriorityQueue

/**
 * 1011. Capacity To Ship Packages Within D Days
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
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