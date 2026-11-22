package com.shlapak.yaroslav.leetcode.problems.p0190

/**
 * LeetCode 190: Reverse Bits.
 *
 * Reverses the order of all 32 bits in an integer.
 *
 * @see <a href="https://leetcode.com/problems/reverse-bits/">Problem statement</a>
 */
class ReverseBits {
    class BinaryString {
        /**
         * Pads the base-2 representation to 32 digits before reversing it.
         * Unsigned conversion preserves the full bit pattern, including the sign bit.
         *
         * Time: O(1) for 32-bit integers.
         * Space: O(1) for the temporary strings of up to 32 digits.
         */
        fun reverseBits(n: Int): Int {
            val binary = n.toUInt().toString(2).padStart(Int.SIZE_BITS, '0')
            return binary.reversed().toUInt(2).toInt()
        }
    }

    class BitByBit {
        /**
         * Appends the lowest remaining bit to the result on each of 32 iterations.
         * The fixed count preserves leading zeros, and the unsigned shift fills with zeros.
         *
         * Time: O(1) for 32-bit integers.
         * Space: O(1).
         */
        fun reverseBits(n: Int): Int {
            var remaining = n
            var reversed = 0
            repeat(Int.SIZE_BITS) {
                reversed = (reversed shl 1) or (remaining and 1)
                remaining = remaining ushr 1
            }
            return reversed
        }
    }

    class ParallelBitSwaps {
        /**
         * Swaps adjacent groups of 1, 2, 4, 8, and 16 bits across the entire word.
         * Each stage doubles the width of the groups whose bits are already reversed.
         * Five stages replace the 32 iterations of the bit-by-bit approach.
         *
         * Time: O(1) for 32-bit integers.
         * Space: O(1).
         */
        fun reverseBits(n: Int): Int {
            var bits = ((n and 0x55555555) shl 1) or ((n ushr 1) and 0x55555555)
            bits = ((bits and 0x33333333) shl 2) or ((bits ushr 2) and 0x33333333)
            bits = ((bits and 0x0f0f0f0f) shl 4) or ((bits ushr 4) and 0x0f0f0f0f)
            bits = ((bits and 0x00ff00ff) shl 8) or ((bits ushr 8) and 0x00ff00ff)
            return (bits shl 16) or (bits ushr 16)
        }
    }
}
