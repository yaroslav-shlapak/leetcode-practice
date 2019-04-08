package com.shlapak.yaroslav.leetcode.problem6

import kotlin.test.assertEquals

/**
 * Created on 2019/04/08.
 * https://leetcode.com/problems/zigzag-conversion/
 */
class Solution {
    fun convert(s: String, numRows: Int): String {

    }
}

fun main() {
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
}