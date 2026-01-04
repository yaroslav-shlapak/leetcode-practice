package problem821
/**
 * 821. Shortest Distance to a Character
 * https://leetcode.com/problems/shortest-distance-to-a-character/
 */
class ShortestDistanceToACharacter {
    class Straightforward {
        fun shortestToChar(s: String, c: Char): IntArray {
            val n = s.length
            val result = IntArray(n)
            var prev = -n

            // Left to right
            for (i in 0 until n) {
                if (s[i] == c) prev = i
                result[i] = i - prev
            }

            // Right to left
            prev = 2 * n
            for (i in n - 1 downTo 0) {
                if (s[i] == c) prev = i
                result[i] = minOf(result[i], prev - i)
            }

            return result
        }
    }

    class TwoPasses {
        fun shortestToChar(s: String, c: Char): IntArray {
            val n = s.length
            val res = IntArray(n) { n }
            var prev = -n
            for (i in 0 until n) {
                if (s[i] == c) {
                    prev = i
                }
                res[i] = i - prev
            }
            prev = 2 * n
            for (i in n - 1 downTo 0) {
                if (s[i] == c) {
                    prev = i
                }
                res[i] = minOf(res[i], prev - i)
            }
            return res
        }
    }

    class TwoPointers {
        fun shortestToChar(s: String, c: Char): IntArray {
            val n = s.length
            val res = IntArray(n)
            var left = -n
            var right = s.indexOf(c)
            for (i in 0 until n) {
                if (i > right) {
                    left = right
                    right = s.indexOf(c, left + 1)
                    if (right == -1) {
                        right = 2 * n
                    }
                }
                res[i] = minOf(i - left, right - i)
            }
            return res
        }
    }
}