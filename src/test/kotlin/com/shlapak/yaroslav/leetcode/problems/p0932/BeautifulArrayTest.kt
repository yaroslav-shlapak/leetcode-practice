package com.shlapak.yaroslav.leetcode.problems.p0932

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests both defining properties of the arrays built by [BeautifulArray.ParityExpansion]. */
class BeautifulArrayTest : FreeSpec({
    val solution = BeautifulArray.ParityExpansion()

    "official examples" {
        assertBeautiful(4, solution.beautifulArray(4))
        assertBeautiful(5, solution.beautifulArray(5))
    }

    "smallest and largest supported sizes" {
        assertBeautiful(1, solution.beautifulArray(1))
        assertBeautiful(1000, solution.beautifulArray(1000))
    }

    "sizes around a power of two" {
        for (n in 31..33) {
            assertBeautiful(n, solution.beautifulArray(n))
        }
    }
})

private fun assertBeautiful(n: Int, values: IntArray) {
    values.sorted() shouldBe (1..n).toList()

    val positions = IntArray(n + 1)
    values.forEachIndexed { index, value -> positions[value] = index }
    for (left in values.indices) {
        for (right in left + 1 until values.size) {
            val sum = values[left] + values[right]
            if (sum % 2 != 0) continue

            val average = sum / 2
            check(positions[average] !in left + 1 until right) {
                "For n=$n, the average $average occurs between indices $left and $right"
            }
        }
    }
}
