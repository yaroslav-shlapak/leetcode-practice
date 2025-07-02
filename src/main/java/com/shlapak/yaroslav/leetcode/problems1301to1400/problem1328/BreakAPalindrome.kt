package com.shlapak.yaroslav.leetcode.problems1301to1400.problem1328

/**
 * 1328. Break a Palindrome
 * https://leetcode.com/problems/break-a-palindrome/
 */
class BreakAPalindrome {
    class OptimizedMySolution {
        fun breakPalindrome(p: String): String {
            if (p.length == 1) return ""
            val res = StringBuilder()
            for (i in 0 until p.length / 2) {
                val ch = p[i]
                if (ch != 'a') {
                    res.append('a')
                    res.append(p.substring(i + 1, p.length))
                    return res.toString()
                } else {
                    res.append(ch)
                }
            }
            res.append(p.substring(p.length / 2, p.length - 1))
            res.append('b')
            return res.toString()
        }
    }
    class BruteForce {
        fun breakPalindrome(palindrome: String): String {
            if (palindrome.length == 1) return ""

            for (i in 0 until palindrome.length) {
                if (palindrome[i] != 'a') {
                    return palindrome.substring(0, i) + 'a' + palindrome.substring(i + 1)
                }
            }

            return palindrome.substring(0, palindrome.length - 1) + 'b'
        }
    }

    class Optimized {
        fun breakPalindrome(palindrome: String): String {
            if (palindrome.length <= 1) {
                return ""
            }

            val chars = palindrome.toCharArray()

            for (i in 0 until chars.size / 2) {
                if (chars[i] != 'a') {
                    chars[i] = 'a'
                    return String(chars)
                }
            }

            // If the loop finishes, the first half is all 'a's.
            // Change the last character to 'b'.
            chars[chars.size - 1] = 'b'
            return String(chars)
        }
    }

    class Optimized2 {
        fun breakPalindrome(palindrome: String): String {
            if (palindrome.length == 1) return ""

            val sb = StringBuilder(palindrome)
            for (i in 0 until palindrome.length / 2) {
                if (sb[i] != 'a') {
                    sb[i] = 'a'
                    return sb.toString()
                }
            }

            sb[palindrome.length - 1] = 'b'
            return sb.toString()
        }
    }
}