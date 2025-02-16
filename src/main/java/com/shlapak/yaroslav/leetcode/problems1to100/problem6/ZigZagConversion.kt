package com.shlapak.yaroslav.leetcode.problems1to100.problem6

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

fun main() {
    //println(Solution().convert("PAYPALISHIRING", 5))
    assertEquals("PYAIHRNAPLSIIG", Solution().convert("PAYPALISHIRING", 2))
    /*
    PYAIHRN
    APLSIIG
    */
    assertEquals("PAHNAPLSIIGYIR", Solution().convert("PAYPALISHIRING", 3))
    /*
    P   A   H   N
    A P L S I I G
    Y   I   R
    */
    assertEquals("PINALSIGYAHRPI", Solution().convert("PAYPALISHIRING", 4))
    /*
    P     I    N
    A   L S  I G
    Y A   H R
    P     I
    */

    assertEquals("PHASIYIRPLIGAN", Solution().convert("PAYPALISHIRING", 5))
    /*
    P       H
    A     S I
    Y   I   R
    P L     I G
    A       N
    */
    assertEquals("A", Solution().convert("A", 1))
    assertEquals("A", Solution().convert("A", 0))
    assertEquals("AB", Solution().convert("AB", 1))
}