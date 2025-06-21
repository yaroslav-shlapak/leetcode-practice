package com.shlapak.yaroslav.leetcode.problems801to900.problem833

/**
 * 833. Find And Replace in String
 * https://leetcode.com/problems/find-and-replace-in-string/
 */
class FindAndReplaceInString {
    class FirstSolution {
        fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String {
            val map = mutableMapOf<Int, MutableList<Pair<String, String>>>()

            for (i in indices.indices) {
                map.getOrPut(indices[i]) { mutableListOf() }.add(sources[i] to targets[i])
            }
            val sb = StringBuilder()
            var i = 0
            outer@ while (i < s.length) {
                val values = map[i]
                if (values != null) {
                    for (j in 0 until values.size) {
                        val value = values[j]
                        if (s.length >= i + value.first.length
                            && value.first == s.substring(i, i + value.first.length)
                        ) {
                            sb.append(value.second)
                            i += value.first.length
                            continue@outer
                        }
                    }
                }
                sb.append(s[i])
                i++
            }

            return sb.toString()
        }
    }

    class SecondSolution {
        fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String {
            val match = IntArray(s.length) { -1 }

            for (i in indices.indices) {
                if (s.startsWith(sources[i], indices[i])) {
                    match[indices[i]] = i
                }
            }

            val strb = StringBuilder()
            var i = 0
            while (i < s.length) {
                if (match[i] == -1) {
                    strb.append(s[i])
                    i++
                } else {
                    strb.append(targets[match[i]])
                    i += sources[match[i]].length
                }
            }

            return strb.toString()
        }
    }

    class ThirdSolution {
        fun findReplaceString(s: String, indices: IntArray, sources: Array<String>, targets: Array<String>): String {
            val re = mutableListOf<Triple<Int, String, String>>()

            for (i in 0 until indices.size) {
                val index = indices[i]
                val source = sources[i]
                val target = targets[i]
                if (s.startsWith(source, index)) {
                    re.add(Triple(index, source, target))
                }
            }

            re.sortByDescending { it.first }

            val sb = StringBuilder(s)
            for ((index, source, target) in re) {
                sb.replace(index, index + source.length, target)
            }

            return sb.toString()
        }
    }
}