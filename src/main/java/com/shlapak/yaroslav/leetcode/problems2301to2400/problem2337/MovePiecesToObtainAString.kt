package com.shlapak.yaroslav.leetcode.problems2301to2400.problem2337

/**
 * 2337. Move Pieces to Obtain a String
 * https://leetcode.com/problems/move-pieces-to-obtain-a-string/
 */
class MovePiecesToObtainAString {

    class TwoPointers1 {
        fun canChange(start: String, target: String): Boolean {
            // start = "_L__R__R_"
            //.                |
            // target= "L______RR"
            //                 |
            // "_L__R__R_L"
            //      |
            // "L______RR_"
            //         |
            if (start.replace("_", "") != target.replace("_", "")) {
                return false
            }
            var i = 0
            var j = 0
            while (i < start.length && j < target.length) {
                //println("i: $i, start[i]: ${start[i]}, j: $j, target[j]: ${target[j]}")
                while (i < start.length && start[i] == '_') {
                    i++
                }
                while (j < target.length && target[j] == '_') {
                    j++
                }

                if (i == start.length || j == target.length) {
                    break
                }

                // left cannot move right
                if (start[i] == 'L' && i < j) {
                    return false
                }
                // right cannot move left
                if (start[i] == 'R' && i > j) {
                    return false
                }
                i++
                j++
            }
            return true
        }
    }

    class TwoPointers2 {
        fun canChange(start: String, target: String): Boolean {
            // start = "_L__R__R_"
            //.                |
            // target= "L______RR"
            //                 |
            // "_L__R__R_L"
            //      |
            // "L______RR_"
            //         |
            // "_L" i = 2
            //    |
            // "LR" j = 1
            //   |
            var i = 0
            var j = 0
            while (i < start.length || j < target.length) {
                //println("i: $i, start[i]: ${start[i]}, j: $j, target[j]: ${target[j]}")
                while (i < start.length && start[i] == '_') {
                    i++
                }
                while (j < target.length && target[j] == '_') {
                    j++
                }

                if (i == start.length || j == target.length) {
                    return i == start.length && j == target.length
                }

                if (start[i] != target[j]) {
                    return false
                }

                // left cannot move right
                if (start[i] == 'L' && i < j) {
                    return false
                }
                // right cannot move left
                if (start[i] == 'R' && i > j) {
                    return false
                }
                i++
                j++
            }
            return true
        }
    }

    class TwoPointers3 {
        fun canChange(start: String, target: String): Boolean {
            val n = start.length
            var i = 0
            var j = 0

            // Skip underscores and compare characters
            while (i < n && j < n) {
                // Skip underscores in start
                if (start[i] == '_') {
                    i++
                    continue
                }

                // Skip underscores in target
                if (target[j] == '_') {
                    j++
                    continue
                }

                // Check if characters match and movement constraints
                if (start[i] != target[j] ||  // Characters must match
                    (start[i] == 'L' && i < j) ||  // 'L' can only move left
                    (start[i] == 'R' && i > j)) {  // 'R' can only move right
                    return false
                }

                i++
                j++
            }

            // Skip any remaining underscores
            while (i < n && start[i] == '_') i++
            while (j < n && target[j] == '_') j++

            // Both strings must be fully processed
            return i == n && j == n
        }
    }

    class TwoPointers4 {
        fun canChange(start: String, target: String): Boolean {
            // Rule 1: Relative order of non-'_' characters must be the same.
            if (start.replace("_", "") != target.replace("_", "")) {
                return false
            }

            var i = 0 // Pointer for start
            var j = 0 // Pointer for target

            while (i < start.length) {
                // Skip underscores to find the next character in start
                if (start[i] == '_') {
                    i++
                    continue
                }

                // Skip underscores to find the corresponding character in target
                while (target[j] == '_') {
                    j++
                }

                // Rule 2: 'L' can only move left (or stay).
                if (start[i] == 'L' && i < j) {
                    return false
                }

                // Rule 3: 'R' can only move right (or stay).
                if (start[i] == 'R' && i > j) {
                    return false
                }

                // Move to the next character pair.
                i++
                j++
            }

            return true
        }
    }

    class IndexLists1 {
        fun canChange(start: String, target: String): Boolean {
            // Extracting indices of L and R for both strings
            val startIndices = start.mapIndexedNotNull { index, char -> if (char != '_') char to index else null }
            val targetIndices = target.mapIndexedNotNull { index, char -> if (char != '_') char to index else null }

            // Rule 1: The characters and their relative order must match.
            if (startIndices.map { it.first } != targetIndices.map { it.first }) {
                return false
            }

            // Rule 2 & 3: Check positions for each character
            for (k in startIndices.indices) {
                val (char, startIndex) = startIndices[k]
                val (_, targetIndex) = targetIndices[k]

                if (char == 'L' && startIndex < targetIndex) {
                    return false // 'L' moved right
                }
                if (char == 'R' && startIndex > targetIndex) {
                    return false // 'R' moved left
                }
            }

            return true
        }
    }

    class IndexLists2 {
        fun canChange(start: String, target: String): Boolean {
            val startIndices = mutableListOf<Int>()
            val targetIndices = mutableListOf<Int>()

            for (i in start.indices) {
                if (start[i] != '_') {
                    startIndices.add(i)
                }
            }

            for (i in target.indices) {
                if (target[i] != '_') {
                    targetIndices.add(i)
                }
            }

            if (startIndices.size != targetIndices.size) {
                return false
            }

            for (i in startIndices.indices) {
                if (start[startIndices[i]] != target[targetIndices[i]]) {
                    return false
                }
                if (start[startIndices[i]] == 'L' && startIndices[i] < targetIndices[i]) {
                    return false
                }
                if (start[startIndices[i]] == 'R' && startIndices[i] > targetIndices[i]) {
                    return false
                }
            }

            return true
        }
    }

    class Counting {
        fun canChange(start: String, target: String): Boolean {
            // Rule 1: Relative order must be the same
            if (start.replace("_", "") != target.replace("_", "")) {
                return false
            }

            // Rule 3 (for 'R'): Check from left to right
            var rBalance = 0
            for (i in start.indices) {
                if (start[i] == 'R') rBalance++
                if (target[i] == 'R') rBalance--
                if (rBalance < 0) return false // target has an 'R' that start hasn't supplied yet
            }

            // Rule 2 (for 'L'): Check from right to left
            var lBalance = 0
            for (i in start.indices.reversed()) {
                if (start[i] == 'L') lBalance++
                if (target[i] == 'L') lBalance--
                if (lBalance < 0) return false // target has an 'L' that start hasn't supplied yet
            }

            return true
        }
    }


}