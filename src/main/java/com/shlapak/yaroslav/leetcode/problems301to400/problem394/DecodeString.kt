package com.shlapak.yaroslav.leetcode.problems301to400.problem394

import java.util.LinkedList
import java.util.Stack

/**
 * 394. Decode String
 * https://leetcode.com/problems/decode-string/description/
 */
class DecodeString {
    data class DecodePoints(
        val startOfStringToRepeat: Int, val startOfNumber: Int, val repetitions: Int
    )

    fun decodeString(s: String): String {
        val stack = LinkedList<DecodePoints>()

        findStartingPoints(s, stack)

        var temp = s
        while (!stack.isEmpty()) {
            val (startOfStringToRepeat, startOfNumber, repetitions) = stack.removeFirst()
            var stringToInsert = ""
            var end = startOfNumber
            for (i in startOfNumber..temp.lastIndex) {
                if (temp[i] == ']') {
                    end = i + 1
                    stringToInsert = temp.substring(startOfStringToRepeat + 1, i).repeat(repetitions)
                    break
                }
            }

            temp = temp.substring(0, startOfNumber) + stringToInsert + temp.substring(end, temp.length)
        }

        return temp
    }

    private fun findStartingPoints(
        s: String, stack: LinkedList<DecodePoints>
    ) {
        for (i in s.indices) {
            if (s[i] == '[') {
                val (rep, start) = findRepetitions(s, i)
                stack.addFirst(
                    /* e = */ DecodePoints(
                        startOfStringToRepeat = i, startOfNumber = start, repetitions = rep
                    )
                )
            }
        }
    }

    private fun findRepetitions(s: String, end: Int): Pair<Int, Int> {
        for (i in end downTo 0) {
            if (i == 0 || !s[i - 1].isDigit()) {
                return s.substring(i, end).toInt() to i
            }
        }
        return 0 to 0
    }
}

class DecodeStingRecursive {
    fun decodeString(s: String): String {
        return decode(s, 0).first
    }

    fun decode(s: String, idx: Int): Pair<String, Int> {
        var k = 0
        var i = idx
        val result = StringBuilder()
        while (i < s.length) {
            val ch = s[i]
            if (ch in '0'..'9') {
                k = k * 10 + (ch - '0')
                i++
            } else if (ch == '[') {
                val (decoded, newIdx) = decode(s, i + 1)
                repeat(k) {
                    result.append(decoded)
                }
                k = 0
                i = newIdx + 1
            } else if (ch == ']') {
                return Pair(result.toString(), i)
            } else {
                result.append(ch)
                i++
            }
        }
        return Pair(result.toString(), i)
    }
}

class DecodeString2Stacks { // looks like it's the best solution
    fun decodeString(s: String): String {
        val countStack = Stack<Int>()
        val stack = Stack<StringBuilder>()
        var current = StringBuilder()
        var temp = 0

        for (char in s) {
            when {
                char.isDigit() -> {
                    temp = temp * 10 + (char - '0')
                }

                char == '[' -> {
                    countStack.push(temp)
                    stack.push(current)
                    temp = 0
                    current = StringBuilder()
                }

                char == ']' -> {
                    val charStack = stack.pop()
                    val t = countStack.pop()
                    repeat(t) {
                        charStack.append(current)
                    }
                    current = charStack
                }

                else -> {
                    current.append(char)
                }
            }

        }
        return current.toString()

    }
}

class DecodeStringTailRecursion {
    fun decodeString(s: String): String {
        /*
            recursion?
            need to evaluate inner most bracket first
            keep going until you see 2 closest together open and cloes bracket


            3[a2[c]]

            3[a]2[bc]

            2[a3[b]]
            use indices to keep track of current encoded string, if it's well formed, it has to end in brakcet

            do inner most first

         */


        var i = 0

        fun decodeCur(): String {
            var result = ""
            while (i < s.length && s[i] != ']') {
                if (s[i].isDigit()) {
                    var k = 0
                    while (i < s.length && s[i].isDigit()) {
                        k = k * 10 + s[i].digitToInt()
                        i++
                    }

                    // skip [
                    i++

                    val str = decodeCur()

                    // skip ]
                    i++

                    while (k > 0) {
                        result = result + str
                        k--
                    }
                } else {
                    result = result + s[i]
                    i++
                }
            }

            return result
        }

        return decodeCur()
    }
}

class DecodeString_SingleStack {
    fun decodeString(s: String): String {
        val stack = mutableListOf<Pair<StringBuilder, Int>>()
        var currSb = StringBuilder()
        var currTimes = 0

        for (c in s) {
            when (c) {
                in '0'..'9' -> currTimes = currTimes * 10 + (c - '0')
                '[' -> {
                    stack.add(currSb to currTimes)
                    currSb = StringBuilder()
                    currTimes = 0
                }

                ']' -> {
                    val (prevSb, times) = stack.removeLast()
                    repeat(times) {
                        prevSb.append(currSb)
                    }
                    currSb = prevSb
                }

                else -> currSb.append(c)
            }
        }

        return currSb.toString()
    }
}

class Solution_ReversiveStack {
    fun decodeString(s: String): String {
        val stack = ArrayDeque<Char>()

        for (ch in s) {
            if (ch == ']') {
                val text = StringBuilder()
                while (stack.isNotEmpty() && stack.last().isLetter()) {
                    text.append(stack.removeLast())
                }
                stack.removeLast() // remove [
                val repStr = StringBuilder()
                while (stack.isNotEmpty() && stack.last().isDigit()) {
                    repStr.append(stack.removeLast())
                }
                val rep = repStr.reversed().toString().toInt()
                val temp = StringBuilder()
                for (i in 0 until rep) {
                    temp.append(text)
                }

                for (i in temp.length - 1 downTo 0) {
                    stack.addLast(temp[i])
                }
            } else {
                stack.addLast(ch)
            }
        }

        var res = StringBuilder()
        for (i in 0 until stack.size) {
            res.append(stack.removeFirst()) // reversed order
        }

        return res.toString()
    }
}

class Solution_SayvingMainStringToStack {
    fun decodeString(s: String): String {
        val stack = ArrayDeque<Pair<Int, StringBuilder>>()
        var sb = StringBuilder()
        var curr = 0

        for (ch in s) {
            when {
                ch in '0'..'9' -> {
                    curr = 10 * curr + (ch - '0')
                }

                ch == ']' -> {
                    val (mult, mainString) = stack.removeLast()
                    repeat(mult) {
                        mainString.append(sb)
                    }
                    sb = mainString
                }

                ch == '[' -> {
                    stack.addLast(curr to sb) // save main string
                    sb = StringBuilder()
                    curr = 0
                }

                else -> {
                    sb.append(ch)
                }
            }
        }

        return sb.toString()
    }
}