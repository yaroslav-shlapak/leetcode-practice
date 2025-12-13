package com.shlapak.yaroslav.leetcode.problems401to500.problem402

/**
 * 402. Remove K Digits
 * https://leetcode.com/problems/remove-k-digits/
 */
class RemoveKDigits {

    class StackApproach {
        fun removeKdigits(num: String, k: Int): String {
            if (num.length <= k) return "0"
            val stack = ArrayDeque<Char>()
            var count = k
            // remove all that larger than last in stack
            for (ch in num) {
                while (count > 0 && stack.isNotEmpty() && ch < stack.last()) {
                    stack.removeLast()
                    count--
                }
                stack.addLast(ch)
            }
            // remove remaining endings if count is still not zero
            for (i in 0 until count) {
                stack.removeLast()
            }
            // remove leading zeros
            while (stack.size > 1 && stack.first() == '0') {
                stack.removeFirst()
            }
            // convert stack to stirng
            return stack.toList().joinToString("")
        }
    }

    class RecursiveApproach {
        fun removeKdigits(num: String, k: Int): String {
            if (num.length <= k) return "0"
            if (k == 0) {
                // remove leading zeros
                var i = 0
                while (i < num.length - 1 && num[i] == '0') {
                    i++
                }
                return num.substring(i)
            }

            for (i in 0 until num.length - 1) {
                if (num[i] > num[i + 1]) {
                    val newNum = num.removeRange(i, i + 1)
                    return removeKdigits(newNum, k - 1)
                }
            }
            // if we did not find any larger digit, remove last one
            val newNum = num.dropLast(1)
            return removeKdigits(newNum, k - 1)
        }
    }
}