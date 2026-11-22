package com.shlapak.yaroslav.leetcode.problems.p1834

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests [SingleThreadedCPU.PriorityQueueSimulation] with scheduling edge cases. */
class SingleThreadedCPUTest : FreeSpec({
    data class Case(val name: String, val tasks: List<Pair<Int, Int>>, val expected: List<Int>)

    val cases = listOf(
        Case("first example", listOf(1 to 2, 2 to 4, 3 to 2, 4 to 1), listOf(0, 2, 3, 1)),
        Case("second example", listOf(7 to 10, 7 to 12, 7 to 5, 7 to 4, 7 to 2), listOf(4, 3, 2, 0, 1)),
        Case("single task", listOf(10 to 3), listOf(0)),
        Case("idle between tasks", listOf(10 to 1, 1 to 1, 20 to 1), listOf(1, 0, 2)),
        Case("ties use original index", listOf(1 to 5, 2 to 3, 1 to 3), listOf(2, 1, 0)),
        Case("tasks arriving at completion are eligible", listOf(1 to 3, 2 to 5, 4 to 1), listOf(0, 2, 1)),
        Case("clock exceeds int range", listOf(1 to 1000000000, 1 to 1000000000, 1 to 1000000000, 2 to 1), listOf(0, 3, 1, 2)),
        Case("queue drains after last enqueue", listOf(1 to 1, 1 to 3, 1 to 2), listOf(0, 2, 1))
    )

    cases.forEach { case ->
        case.name {
            val tasks = case.tasks.map { (enq, proc) -> intArrayOf(enq, proc) }.toTypedArray()
            val original = tasks.map { it.toList() }
            SingleThreadedCPU.PriorityQueueSimulation().getOrder(tasks).toList() shouldBe case.expected
            tasks.map { it.toList() } shouldBe original
        }
    }
})
