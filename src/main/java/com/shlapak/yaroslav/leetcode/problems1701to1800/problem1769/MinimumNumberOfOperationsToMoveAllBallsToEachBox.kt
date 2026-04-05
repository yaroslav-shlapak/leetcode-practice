package com.shlapak.yaroslav.leetcode.problems1701to1800.problem1768

/*
 * 1769. Minimum Number of Operations to Move All Balls to Each Box
 * https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/
 */
class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    class Solution {
        fun minOperations(boxes: String): IntArray {
            val n = boxes.length
            var dFromLeft = 0
            var numOf1FromLeft = 0
            // "001011"
            for (i in 1 until n) {
                if (boxes[i] == '1') {
                    dFromLeft += i
                    numOf1FromLeft++
                }
            }

            var dFromRight = 0
            var numOf1FromRight = 0
            // "001011"
            for (i in n - 2 downTo 0) {
                if (boxes[i] == '1') {
                    dFromRight += n - i - 1
                    numOf1FromRight++
                }
            }

            var fromLeft = IntArray(n)
            fromLeft[0] = dFromLeft
            for (i in 1 until n) {
                val cur = boxes[i].digitToInt()
                numOf1FromLeft = numOf1FromLeft - cur
                dFromLeft = dFromLeft - cur - numOf1FromLeft
                fromLeft[i] = dFromLeft
            }

            var fromRight = IntArray(n)
            fromRight[n - 1] = dFromRight
            var res = IntArray(n)
            for (i in n - 2 downTo 0) {
                val cur = boxes[i].digitToInt()
                numOf1FromRight = numOf1FromRight - cur
                dFromRight = dFromRight - cur - numOf1FromRight
                fromRight[i] = dFromRight
                res[i] = fromRight[i] + fromLeft[i]
            }
            res[n - 1] += fromRight[n - 1]

            return res
        }
    }

// O(N^2)
// "110" ->
// [1,1,3]

// "001011"
// [11,8,5,4,3,4]
// 11 - 8 = 2
// 0 -> [002045]
// 1 -> [001034] - numOfOnes, distanceToTheRight and distanceFromTheLeft

// "001011"
//       |
// formLeft = formLeft - cur - (onesFromLeft - cur) // 1
// onesFromLeft = onesFromLeft - cur // 1
// [11,8,5,3,1,0] - fromLeft

// "001011"
//   |
// formRight = formRight - cur - (onesFromRight - cur) // 0
// onesFromRight = onesFromRight - cur // 0

// [11,8,5,3,1,0] - fromLeft
// [0 ,0,0,1,2,4] - fromRight
// [11,8,5,4,3,4]
// 11 formLeft
// 3 onesFromLeft
// 4 formRight
// 2 onesFromRight
}