package com.shlapak.yaroslav.leetcode.problems.p0032

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.FreeSpec

/**
 * Tests [LongestValidParentheses], [SolutionFaster], [SolutionSlow].
 */
class LongestValidParenthesesTest : FreeSpec({

    "longestValidParentheses" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "nums: ${input}, expected: ${expected}" {
                val actual = LongestValidParentheses().longestValidParentheses(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

    "longestValidParentheses faster" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "nums: ${input}, expected: ${expected}" {
                val actual = SolutionFaster().longestValidParentheses(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

    "longestValidParentheses slow" - {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            "nums: ${input}, expected: ${expected}" - {
                val actual = SolutionSlow().longestValidParentheses(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

})

private fun getInputs(): Map<String, Int> {
    return mapOf(
            "(()" to 2,
            "())" to 2,
            ")()())" to 4,
            "())()((())" to 4,
            "())()(())" to 6,
            ")))))()()" to 4,
            "()())))))" to 4,
            ")))()())))))" to 4,
            ")))((())))))))" to 6,
            "())()()(())((()(()()(((()))((((())((()(())()())(()((((()))()(()))(())()(())(()(((((())((((((()())())(()(()((())()))(()))))))()(()))((((())()()()))()()()(((()(()())(()()(()(()()(((()))))))()()))())())((()()))))))((()))(((()((())()(()()))((())))()()())))))))()))))(()))))()))()))()((())))((()))(()))))))(((()))))))))()(()()()(())((())()))()()(())))()()))(()())()))(((()())()))((())((((()))(()(()(()()()(((())()(((((()))((()(((((())(()()))((((((((()(()(()(()(())))(())(()())())(()((((()(())((()(())))(())))()(((((()(()()(())))))))())(())(())(()()(((())))((()))(((((()))))())))()((()))()))))())))))((())(((((()()))((((())))(((()(()(())())(((()(()(()()()())))())()))((()((())())()()()(((())(((((()((((((()((()())))((((())((()(((((((()(()((()()()(()(()())(()(()()((((())))()(((()())))(()()))()(()()()()(((((())(()))))((()))())))()((((((()))())))()(()))(())))((((()())(((((()()())(((((())(()())(()))))()(()()))()))))))())))(((())(()(()()))(()))()(((())))())((((()(((()))))))()(()(()))()()(()()))))))))((()))))))(())((()((()))()))((((((()())))))(()((())((((()))))(()(()()()()(()))()()(()(()))(()()(((((((()())(())(()())((())())()(()())((())()())())(()())))())))(())())())(())((()())(((()()))()))()()))()(()(())((((((((())))()((())((()((((((((((()))))(()(((((())(()(()())())))((())())))))()))(()((()()))((()((())()()()((()(())())((())())(()()(((())))))())()()(()))()())(()(()((())))((((()()(())))())(())(()(()(())())())(()()())()(())())))(()()(((())))((()()(((())()()(()())((((()()(()())(()((((()(()()(()(()(((()((()())(()()))(()((((()(((((()))))()()))(((()((((((()(()()()()())()))(()(())))))((()(((()())())))(((()()))(()(()(((((((()()))(()(())))())()(())())(())(()))(())(()))()()(()()())))))()))()((())(((()((((((((())()()))())))((()())(" to 310
    )
}
