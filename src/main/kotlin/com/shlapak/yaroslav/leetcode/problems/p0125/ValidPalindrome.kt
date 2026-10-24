package com.shlapak.yaroslav.leetcode.problems.p0125

/**
 * LeetCode 125: Valid Palindrome.
 *
 * Checks for a palindrome while ignoring nonalphanumeric characters and case.
 *
 * @see <a href="https://leetcode.com/problems/valid-palindrome/">Problem statement</a>
 */
class ValidPalindrome {
    class TwoPointers {
        fun isPalindrome(s: String): Boolean {
            var r = s.length - 1
            var l = 0
            while (r > l) {
                when {
                    !s[r].isLetterOrDigit() -> {
                        r--
                    }

                    !s[l].isLetterOrDigit() -> {
                        l++
                    }

                    s[r].lowercase() == s[l].lowercase() -> {
                        r--
                        l++
                    }

                    else -> {
                        return false
                    }
                }
            }
            return true
        }
    }

    class RegexSolution {
        fun isPalindrome(s: String): Boolean {
            val refined = s.lowercase().replace(Regex("[^a-z0-9]"), "")
            return refined == refined.reversed()
        }
    }

    class StackSolution {
        fun isPalindrome(s: String): Boolean {
            val stack = ArrayDeque<Char>()
            val queue = ArrayDeque<Char>()
            for (c in s.lowercase()) {
                if (c.isLetterOrDigit()) {
                    stack.addLast(c)
                    queue.addLast(c)
                }
            }
            while (stack.isNotEmpty()) {
                if (stack.removeLast() != queue.removeFirst()) {
                    return false
                }
            }
            return true
        }
    }

    class BuiltInFunctions {
        fun isPalindrome(s: String): Boolean {
            val refined = s.lowercase().filter { it.isLetterOrDigit() }
            return refined == refined.reversed()
        }
    }

    class DorkyTwoPointers {
        fun isPalindrome(s: String): Boolean {
            var r = s.length - 1
            var l = 0
            // "A man, a plan, a canal: Panama"
            //  |                            |
            while (r > l) {
                while (l < s.length - 1 && !s[l].isLetterOrDigit()) {
                    l++
                }
                while (r > 0 && !s[r].isLetterOrDigit()) {
                    r--
                }
                if (r <= l) {
                    continue
                }
                if (s[r].lowercase() != s[l].lowercase()) {

                    return false
                }
                r--
                l++
            }
            return true
        }
    }

    class RefineAndCheck {
        fun isPalindrome(s: String): Boolean {
            val refined = s.lowercase().filter { it in 'a'..'z' || it in '0'..'9' }
            return refined == refined.reversed()
        }
    }
}
