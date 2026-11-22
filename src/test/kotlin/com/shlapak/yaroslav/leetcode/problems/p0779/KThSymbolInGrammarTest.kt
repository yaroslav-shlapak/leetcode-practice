package com.shlapak.yaroslav.leetcode.problems.p0779

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests [KThSymbolInGrammar.BitParity] and [KThSymbolInGrammar.Recursion]. */
class KThSymbolInGrammarTest : FreeSpec({
    val solutions = listOf(
        "bit parity" to KThSymbolInGrammar.BitParity()::kthGrammar,
        "recursion" to KThSymbolInGrammar.Recursion()::kthGrammar,
    )

    solutions.forEach { (name, solution) ->
        name - {
            "official examples" {
                solution(1, 1) shouldBe 0
                solution(2, 1) shouldBe 0
                solution(2, 2) shouldBe 1
            }

            "all symbols in the first ten rows" {
                var row = "0"
                for (n in 1..10) {
                    row.forEachIndexed { index, symbol ->
                        solution(n, index + 1) shouldBe (symbol - '0')
                    }
                    row = row.flatMap { if (it == '0') listOf('0', '1') else listOf('1', '0') }
                        .joinToString("")
                }
            }

            "largest row and half boundaries" {
                solution(30, 1) shouldBe 0
                solution(30, 1 shl 28) shouldBe 0
                solution(30, (1 shl 28) + 1) shouldBe 1
                solution(30, 1 shl 29) shouldBe 1
            }
        }
    }
})
