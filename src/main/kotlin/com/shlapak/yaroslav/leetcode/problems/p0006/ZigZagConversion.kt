package com.shlapak.yaroslav.leetcode.problems.p0006

import kotlin.test.assertEquals

/**
 * LeetCode 6: Zigzag Conversion.
 *
 * Reorders characters by reading a zigzag arrangement row by row.
 *
 * @see <a href="https://leetcode.com/problems/zigzag-conversion/">Problem statement</a>
 */
class ZigZagConversion {
    class DirectionalApproach {
        fun convert(s: String, numRows: Int): String {
            if (numRows <= 1 || numRows >= s.length) return s

            val rows = Array(numRows) { StringBuilder() }
            var r = 0
            var dir = 1 // +1 going down, -1 going up

            for (ch in s) {
                rows[r].append(ch)
                if (r == 0) dir = 1
                else if (r == numRows - 1) dir = -1
                r += dir
            }

            val out = StringBuilder(s.length)
            for (sb in rows) out.append(sb)
            return out.toString()
        }
    }

    class Solution {
        fun convert(s: String, numRows: Int): String {
            if (s.length <= numRows || numRows == 0 || numRows == 1) {
                return s
            }
            val list = MutableList(size = numRows, init = { StringBuffer() })

            s.asSequence().forEachIndexed { index, char ->
                val i = calculateIndex(index, numRows)
                list[i].append(char)
            }

            val res = StringBuilder()
            list.asSequence().forEach {
                res.append(it)
            }

            return res.toString()
        }

        private fun calculateIndex(index: Int, numRows: Int): Int {
            val zigLen = numRows * 2 - 2
            return when {
                index % zigLen <= numRows - 1 -> {
                    val res = index % zigLen
                    //println("less: $res")
                    res
                }
                else -> { //index % zigLen > numRows
                    val res = zigLen - index % zigLen
                    //println("more: $res")
                    res
                }
            }

        }
    }
}


fun main() {
    //println(ZigZagConversion.Solution().convert("PAYPALISHIRING", 5))
    assertEquals("PYAIHRNAPLSIIG", ZigZagConversion.Solution().convert("PAYPALISHIRING", 2))
    /*
    PYAIHRN
    APLSIIG
    */
    assertEquals("PAHNAPLSIIGYIR", ZigZagConversion.Solution().convert("PAYPALISHIRING", 3))
    /*
    P   A   H   N
    A P L S I I G
    Y   I   R
    */
    assertEquals("PINALSIGYAHRPI", ZigZagConversion.Solution().convert("PAYPALISHIRING", 4))
    /*
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    */

    assertEquals("PHASIYIRPLIGAN", ZigZagConversion.Solution().convert("PAYPALISHIRING", 5))
    /*
    P       H
    A     S I
    Y   I   R
    P L     I G
    A       N
    */
    assertEquals("A", ZigZagConversion.Solution().convert("A", 1))
    assertEquals("A", ZigZagConversion.Solution().convert("A", 0))
    assertEquals("AB", ZigZagConversion.Solution().convert("AB", 1))
}
