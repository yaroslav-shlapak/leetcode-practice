package com.shlapak.yaroslav.leetcode.problem6

import kotlin.test.assertEquals

/**
 * Created on 2019/04/08.
 * https://leetcode.com/problems/zigzag-conversion/
 */
class Solution {
    fun convert(s: String, numRows: Int): String {
        if (s.length <= numRows || numRows == 0 || numRows == 1) {
            return s
        }
        val list = MutableList(size = numRows, init = { StringBuffer() })

        s.asSequence().forEachIndexed{ index, char ->
            val i = calculateIndex(index, numRows)
            list[i].append(char)
        }

        val res = StringBuffer()
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

fun main() {
    //println(Solution().convert("PAYPALISHIRING", 5))
    assertEquals(Solution().convert("PAYPALISHIRING", 2), "PYAIHRNAPLSIIG")
    /*
    PYAIHRN
    APLSIIG
    */
    assertEquals(Solution().convert("PAYPALISHIRING", 3), "PAHNAPLSIIGYIR")
    /*
    P   A   H   N
    A P L S I I G
    Y   I   R
    */
    assertEquals(Solution().convert("PAYPALISHIRING", 4), "PINALSIGYAHRPI")
    /*
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    */

    assertEquals(Solution().convert("PAYPALISHIRING", 5), "PHASIYIRPLIGAN")
    /*
    P       H
    A     S I
    Y   I   R
    P L     I G
    A       N
    */
    assertEquals(Solution().convert("A", 1), "A")
    assertEquals(Solution().convert("A", 0), "A")
    assertEquals(Solution().convert("AB", 1), "AB")
}