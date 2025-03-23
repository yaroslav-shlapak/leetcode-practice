package com.shlapak.yaroslav.leetcode.problems901to1000.problem917

/**
 *
 * 917. Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/description/
 */
class ReverseOnlyLetters {
    fun reverseOnlyLetters(s: String): String {
        val engLetters: Set<Char> = (('a'..'z') + ('A'..'Z')).toSet()
        val arr: CharArray = s.toCharArray()
        var l = 0;
        var r = arr.size - 1
        while (r > l) {
            if (engLetters.contains(arr[r]) && engLetters.contains(arr[l])) {
                arr.swap(r, l)
                r--
                l++
            } else {
                if (!engLetters.contains(arr[r])) {
                    r--
                }
                if (!engLetters.contains(arr[l])) {
                    l++
                }
            }
        }
        return String(arr)
    }

    private fun CharArray.swap(i: Int, j: Int) {
        val temp = this[i]
        this[i] = this[j]
        this[j] = temp
    }
}