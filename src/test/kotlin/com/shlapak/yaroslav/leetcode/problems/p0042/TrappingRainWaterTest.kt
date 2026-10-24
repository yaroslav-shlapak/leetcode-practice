package com.shlapak.yaroslav.leetcode.problems.p0042

import com.shlapak.yaroslav.leetcode.support.asString
import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problems.p0042.TrappingRainWaterLegacy
 **/
class TrappingRainWaterTest : FreeSpec() {

    init {
        "trap" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: ${expected}" {
                    val actual = TrappingRainWaterLegacy().trap(input)
                    actual shouldBe expected
                }
            }
        }

        "trap 2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: ${expected}" {
                    val actual = TrappingRainWaterAlternative2().trap(input)
                    actual shouldBe expected
                }
            }
        }

        "trap 3"  - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input.asString()}, expected: ${expected}" {
                    val actual = TrappingRainWaterEfficientSimple().trap(input)
                    actual shouldBe expected
                }
            }
        }

    }

    private fun getInputs(): Map<IntArray, Int> {
        return mapOf(
                intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1) to 6,
                intArrayOf(3, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1) to 14,
                intArrayOf(0, 1, 0, 2) to 1,
                intArrayOf(0, 2, 0, 1) to 1,
                intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2) to 5,
                intArrayOf(2, 1, 0, 1, 3, 2) to 4,
                intArrayOf(3, 2, 1, 0) to 0

        )
    }

}