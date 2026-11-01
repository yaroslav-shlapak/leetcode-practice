package com.shlapak.yaroslav.leetcode.problems.p0990

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests [SatisfiabilityOfEqualityEquations.UnionFind] and [SatisfiabilityOfEqualityEquations.DepthFirstSearch]. */
class SatisfiabilityOfEqualityEquationsTest : FreeSpec({
    val solutions = listOf(
        "union find" to SatisfiabilityOfEqualityEquations.UnionFind()::equationsPossible,
        "depth-first search" to SatisfiabilityOfEqualityEquations.DepthFirstSearch()::equationsPossible
    )

    for ((name, solve) in solutions) {
        name - {

        "handles the problem examples" {
            solve(arrayOf("a==b", "b!=a")) shouldBe false
            solve(arrayOf("b==a", "a==b")) shouldBe true
        }

        "checks inequalities after all equalities regardless of input order" {
            solve(arrayOf("a!=c", "a==b", "b==c")) shouldBe false
            solve(arrayOf("a==b", "c==d", "b==c", "a!=d")) shouldBe false
        }

        "handles self comparisons and disconnected groups" {
            solve(arrayOf("a!=a")) shouldBe false
            solve(arrayOf("z==z", "a==b", "c==d", "a!=c")) shouldBe true
            solve(arrayOf("a!=b", "b!=c", "a!=c")) shouldBe true
        }

        "preserves input and does not retain state between calls" {
            val equations = arrayOf("a==b", "b!=c")
            solve(equations) shouldBe true
            equations.toList() shouldBe listOf("a==b", "b!=c")
            solve(arrayOf("a!=b")) shouldBe true
        }
        }
    }
})

// TODO review
