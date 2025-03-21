package com.shlapak.yaroslav.leetcode.problems301to400.problem383

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