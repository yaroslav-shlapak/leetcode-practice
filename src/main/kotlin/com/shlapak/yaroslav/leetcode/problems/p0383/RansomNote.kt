package com.shlapak.yaroslav.leetcode.problems.p0383

/**
 * LeetCode 383: Ransom Note.
 *
 * Checks whether available magazine characters can construct a ransom note.
 *
 * @see <a href="https://leetcode.com/problems/ransom-note/">Problem statement</a>
 */
class RansomNote {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val note = IntArray(26)
        for (ch in magazine) {
            note[ch - 'a']++
        }

        for (ch in ransomNote) {
            if (note[ch - 'a'] == 0) return false
            note[ch - 'a']--
        }
        return true
    }
}

class RansomNote_HashMap {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        val map = mutableMapOf<Char, Int>()
        for (ch in ransomNote) {
            map[ch] = (map[ch] ?: 0) + 1
        }

        for (ch in magazine) {
            val count = map[ch]
            when {
                map.isEmpty() -> break
                count == null -> continue
                count > 0 -> map[ch] = count - 1
                count == 0 -> map.remove(ch)
            }
        }
        return map.isEmpty()
    }
}
