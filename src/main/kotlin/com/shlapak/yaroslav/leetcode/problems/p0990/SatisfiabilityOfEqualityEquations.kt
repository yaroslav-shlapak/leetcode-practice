package com.shlapak.yaroslav.leetcode.problems.p0990

/**
 * LeetCode 990: Satisfiability of Equality Equations.
 *
 * Determines whether all equality and inequality relationships can hold at once.
 *
 * @see <a href="https://leetcode.com/problems/satisfiability-of-equality-equations/">Problem statement</a>
 */
class SatisfiabilityOfEqualityEquations {
    /**
     * Joins equal variables, then checks whether any unequal pair belongs to the same set.
     * Variables are lowercase English letters; [equations] is not modified.
     *
     * Time: O(n α(26)), where n is the number of equations.
     * Space: O(26).
     */
    fun equationsPossible(equations: Array<String>): Boolean {
        val parent = IntArray(26) { it }
        val size = IntArray(26) { 1 }

        fun find(value: Int): Int {
            var root = value
            while (parent[root] != root) root = parent[root]
            var current = value
            while (parent[current] != current) {
                val next = parent[current]
                parent[current] = root
                current = next
            }
            return root
        }

        for (equation in equations) {
            if (equation[1] == '=') {
                var left = find(equation[0] - 'a')
                var right = find(equation[3] - 'a')
                if (left != right) {
                    if (size[left] < size[right]) {
                        val temp = left
                        left = right
                        right = temp
                    }
                    parent[right] = left
                    size[left] += size[right]
                }
            }
        }

        return equations.none { equation ->
            equation[1] == '!' && find(equation[0] - 'a') == find(equation[3] - 'a')
        }
    }
}

// TODO review
