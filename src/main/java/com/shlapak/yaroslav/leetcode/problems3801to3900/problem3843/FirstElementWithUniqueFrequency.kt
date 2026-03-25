package com.shlapak.yaroslav.leetcode.problems3801to3900.problem3843

/**
 * https://leetcode.com/problems/first-element-with-unique-frequency
 */
class FirstElementWithUniqueFrequency {
    class TwoHashMaps {
        fun firstUniqueFreq(nums: IntArray): Int {
            var res = -1
            val valToFreq = mutableMapOf<Int, Int>()
            val freqToCount = mutableMapOf<Int, Int>()

            for (n in nums) {
                val freq = valToFreq[n]
                if (freq == null) {
                    valToFreq[n] = 1
                } else {
                    valToFreq[n] = valToFreq[n]!! + 1
                }
            }
            // [1,2,2,3,3,3]
            //        |

            // valToFreq: {1:1,2:2,3:3}

            // valToFreq: {1:1,2:2,3:3}
            //                |
            // freqToCount: {1:1,2:1,3:1}

            for (entry in valToFreq) {
                val (_, freq) = entry // 1

                val count = freqToCount[freq]
                if (count == null) {
                    freqToCount[freq] = 1
                } else {
                    freqToCount[freq] = freqToCount[freq]!! + 1
                }
            }

            // valToFreq: {1:1,2:2,3:3}
            // freqToCount: {1:1,2:1,3:1}

            for (n in nums) {
                if (freqToCount[valToFreq[n]!!] == 1) {
                    res = n
                    break
                }
            }

            return res
        }
    }
}
