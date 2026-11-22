package com.shlapak.yaroslav.leetcode.problems.p2054

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests both approaches with inclusive endpoints. */
class TwoBestNonOverlappingEventsTest : FreeSpec({
    data class Case(val name: String, val events: List<List<Int>>, val expected: Int)

    val cases = listOf(
        Case("first example", listOf(listOf(1, 3, 2), listOf(4, 5, 2), listOf(2, 4, 3)), 4),
        Case("second example", listOf(listOf(1, 3, 2), listOf(4, 5, 2), listOf(1, 5, 5)), 5),
        Case("third example", listOf(listOf(1, 5, 3), listOf(1, 5, 1), listOf(6, 6, 5)), 8),
        Case("touching endpoints overlap", listOf(listOf(1, 2, 10), listOf(2, 3, 20)), 20),
        Case("choose only two", listOf(listOf(3, 3, 3), listOf(1, 1, 5), listOf(2, 2, 4)), 9),
        Case("later suffix maximum", listOf(listOf(1, 1, 10), listOf(2, 3, 1), listOf(4, 4, 9)), 19),
        Case("maximum time and value", listOf(listOf(1, 999999999, 1000000), listOf(1000000000, 1000000000, 1000000)), 2000000)
    )

    cases.forEach { case ->
        case.name {
            val approaches = listOf<(Array<IntArray>) -> Int>(
                TwoBestNonOverlappingEvents.BinarySearch()::maxTwoEvents,
                TwoBestNonOverlappingEvents.PriorityQueueSweep()::maxTwoEvents
            )
            approaches.forEach { solve ->
                val events = case.events.map { it.toIntArray() }.toTypedArray()
                solve(events) shouldBe case.expected
                events.map { it.toList() } shouldBe case.events
            }
        }
    }
})
