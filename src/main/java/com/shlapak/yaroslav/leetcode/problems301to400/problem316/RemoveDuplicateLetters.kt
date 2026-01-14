package com.shlapak.yaroslav.leetcode.problems301to400.problem316

/**
 * 316. Remove Duplicate Letters
 * https://leetcode.com/problems/remove-duplicate-letters/
 */
class RemoveDuplicateLetters {
    class StackApproach {
        fun removeDuplicateLetters(s: String): String {
            val m = mutableMapOf<Char, Int>()
            val st = ArrayDeque<Char>()
            for (i in 0 until s.length) {
                m[s[i]] = i
            }

            val set = mutableSetOf<Char>()
            for (i in 0 until s.length) {
                if (s[i] in set) continue

                while (st.isNotEmpty() && st.last() > s[i] && m[st.last()]!! > i) {
                    val removed = st.last()
                    st.removeLast()
                    set.remove(removed)
                }
                st.addLast(s[i])
                set.add(s[i])
            }

            val res = StringBuilder()
            for (ch in 0 until st.size) {
                res.append(st.removeFirst())
            }

            return res.toString()
        }
    }

    class setAndMapApproach {
        fun removeDuplicateLetters(s: String): String {
            val map = mutableMapOf<Char, Int>()
            val set = mutableSetOf<Char>()

            for (i in s) {
                map[i] = map.getOrDefault(i, 0) + 1
            }

            for (i in s) {
                map[i] = map[i]!! - 1
                if (!set.contains(i)) {
                    while (set.isNotEmpty() && i < set.last() && map[set.last()]!! > 0) {
                        set.remove(set.last())
                    }
                    set.add(i)
                }
            }
            return set.joinToString("")
        }
    }
}