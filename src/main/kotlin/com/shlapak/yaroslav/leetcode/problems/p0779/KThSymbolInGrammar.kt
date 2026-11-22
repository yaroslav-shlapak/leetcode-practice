package com.shlapak.yaroslav.leetcode.problems.p0779

/**
 * LeetCode 779: K-th Symbol in Grammar.
 *
 * Finds the indexed symbol in a row formed by repeatedly replacing 0 with 01 and 1 with 10.
 *
 * @see <a href="https://leetcode.com/problems/k-th-symbol-in-grammar/">Problem statement</a>
 */
class KThSymbolInGrammar {
    /**
     * Traces the symbol to its parent in the preceding row. The first child equals its
     * parent, while the second child flips it.
     *
     * Time: O(n). Space: O(n) for the recursion stack.
     */
    class Recursion {
        fun kthGrammar(n: Int, k: Int): Int {
            if (n == 1) return 0

            val parent = kthGrammar(n - 1, (k + 1) / 2)
            return if (k % 2 == 1) parent else 1 - parent
        }
    }

    /**
     * Each right child flips its parent, so the answer is the parity of the set bits in
     * the zero-based position. The row only limits the valid range of k.
     *
     * Time: O(log k). Space: O(1).
     */
    class BitParity {
        fun kthGrammar(n: Int, k: Int): Int {
            var position = k - 1
            var symbol = 0
            while (position != 0) {
                symbol = symbol xor (position and 1)
                position = position ushr 1
            }
            return symbol
        }
    }
}
