package com.shlapak.yaroslav.leetcode.problems.p1144

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests the [DecreaseElementsToMakeArrayZigzag] approaches. */
class DecreaseElementsToMakeArrayZigzagTest : FreeSpec({
    val approaches = listOf(
        DecreaseElementsToMakeArrayZigzag.TwoLoops()::movesToMakeZigzag,
        DecreaseElementsToMakeArrayZigzag.SeparatePasses()::movesToMakeZigzag,
        DecreaseElementsToMakeArrayZigzag.SinglePass()::movesToMakeZigzag,
    )

    "handle examples and valley boundaries without changing the input" {
        val cases = listOf(
            intArrayOf(1, 2, 3) to 2,
            intArrayOf(9, 6, 1, 6, 2) to 4,
            intArrayOf(1) to 0,
            intArrayOf(1, 1) to 1,
            intArrayOf(1, 1, 1) to 1,
            intArrayOf(2, 1, 2) to 0,
            intArrayOf(1, 3, 2, 1) to 2,
            intArrayOf(1, 1000, 1) to 0,
        )
        for (solve in approaches) for ((nums, expected) in cases) {
            val original = nums.toList()
            solve(nums) shouldBe expected
            nums.toList() shouldBe original
        }
    }
})
