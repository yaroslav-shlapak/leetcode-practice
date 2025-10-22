package com.shlapak.yaroslav.leetcode.problems101to200.problem125

/**
 * 125. Valid Palindrome
 *
 * https://leetcode.com/problems/valid-palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters
 * into lowercase letters and removing all non-alphanumeric characters,
 * it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 *
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