package com.shlapak.yaroslav.leetcode.problem32

import io.kotlintest.shouldBe
import org.spekframework.spek2.Spek

/**
 * Created on 2019/05/28.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem32.Solution
 **/
object SolutionTest : Spek({

    group("longestValidParentheses") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("nums: ${input}, expected: ${expected}") {
                val actual = Solution().longestValidParentheses(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

    group("longestValidParentheses faster") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("nums: ${input}, expected: ${expected}") {
                val actual = SolutionFaster().longestValidParentheses(input)
                println("actual:   ${actual}")
                println("expected: ${expected}")
                actual shouldBe expected
            }
        }
    }

    group("longestValidParentheses slow") {
        val inputs = getInputs()
        inputs.asSequence().forEach { (input, expected) ->
            test("nums: ${input}, expected: ${expected}") {
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