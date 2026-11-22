package com.shlapak.yaroslav.leetcode.problems.p2487

import com.shlapak.yaroslav.leetcode.common.ListNode
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/** Tests all approaches in [RemoveNodesFromLinkedList]. */
class RemoveNodesFromLinkedListTest : FreeSpec({
    val solutions = listOf(
        "two-pass reversal" to RemoveNodesFromLinkedList.ReverseTwoPasses()::removeNodes,
        "three-pass reversal" to RemoveNodesFromLinkedList.ReverseThreePasses()::removeNodes,
        "monotonic stack" to RemoveNodesFromLinkedList.MonotonicStack()::removeNodes,
        "suffix maximum" to RemoveNodesFromLinkedList.SuffixMaximum()::removeNodes,
    )

    for ((name, solve) in solutions) {
        name - {
            "handles examples, equal values, and maximums in different positions" {
                val cases = listOf(
                    listOf(5, 2, 13, 3, 8) to listOf(13, 8),
                    listOf(1, 1, 1, 1) to listOf(1, 1, 1, 1),
                    listOf(5, 2, 3, 10, 4, 1, 2, 5) to listOf(10, 5),
                    listOf(5, 5, 3, 5) to listOf(5, 5, 5),
                    listOf(1, 2, 3, 4) to listOf(4),
                    listOf(4, 3, 2, 1) to listOf(4, 3, 2, 1),
                    listOf(7) to listOf(7),
                    emptyList<Int>() to emptyList(),
                )
                for ((input, expected) in cases) {
                    val nodes = input.map(::ListNode)
                    nodes.zipWithNext().forEach { (a, b) -> a.next = b }
                    var result = solve(nodes.firstOrNull())
                    val actual = mutableListOf<Int>()
                    while (result != null && actual.size <= input.size) {
                        val node = result ?: break
                        // Solutions reuse original nodes and must not introduce cycles.
                        (node in nodes) shouldBe true
                        actual.add(node.`val`)
                        result = node.next
                    }
                    result shouldBe null
                    actual shouldBe expected
                }
            }
        }
    }
})
