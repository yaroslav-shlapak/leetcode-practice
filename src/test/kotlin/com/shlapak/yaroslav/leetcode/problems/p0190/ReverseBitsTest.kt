package com.shlapak.yaroslav.leetcode.problems.p0190

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [ReverseBits.BinaryString], [ReverseBits.BitByBit], and [ReverseBits.ParallelBitSwaps]
 * against the examples, input bounds, and individual bit positions.
 */
class ReverseBitsTest : FreeSpec({
    val approaches = listOf(
        "binary string" to ReverseBits.BinaryString()::reverseBits,
        "bit by bit" to ReverseBits.BitByBit()::reverseBits,
        "parallel bit swaps" to ReverseBits.ParallelBitSwaps()::reverseBits
    )

    approaches.forEach { (name, reverseBits) ->
        name - {
            "first example" {
                reverseBits(43_261_596) shouldBe 964_176_192
            }
            "second example" {
                reverseBits(2_147_483_644) shouldBe 1_073_741_822
            }
            "zero" {
                reverseBits(0) shouldBe 0
            }
            "largest valid input" {
                reverseBits(Int.MAX_VALUE - 1) shouldBe Int.MAX_VALUE - 1
            }
            "a set bit at position i moves to position 31 minus i" {
                for (position in 0 until Int.SIZE_BITS) {
                    reverseBits(1 shl position) shouldBe (1 shl (Int.SIZE_BITS - 1 - position))
                }
            }
        }
    }
})
