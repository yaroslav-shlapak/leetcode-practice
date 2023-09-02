package com.shlapak.yaroslav.leetcode.problem43

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem43.Solution
 **/
class SolutionTest : FreeSpec() {

    init {
        "multiply" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = Solution().multiply(input.first, input.second)
                    actual shouldBe expected
                }
            }
        }

        "multiply 2" - {
            val inputs = getInputs()
            inputs.asSequence().forEach { (input, expected) ->
                "input: ${input}, expected: ${expected}" {
                    val actual = SolutionNaive().multiply(input.first, input.second)
                    actual shouldBe expected
                }
            }
        }
    }

    private fun getInputs(): Map<Pair<String, String>, String> {
        return mapOf(
                Pair("2", "3") to "6",
                Pair("123", "456") to "56088",
                Pair("6913259244", "71103343") to "491555843274052692",
                Pair("498828660196", "840477629533") to "419254329864656431168468",
                Pair("401716832807512840963", "167141802233061013023557397451289113296441069")
                        to "67143675422804947379429215144664313370120390398055713625298709447"
        )
    }
}