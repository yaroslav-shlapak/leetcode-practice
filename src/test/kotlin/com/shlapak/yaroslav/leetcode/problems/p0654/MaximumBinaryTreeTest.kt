package com.shlapak.yaroslav.leetcode.problems.p0654

import com.shlapak.yaroslav.leetcode.common.TreeNode
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [MaximumBinaryTree.MonotonicStack] against the examples and skewed trees.
 */
class MaximumBinaryTreeTest : FreeSpec({
    val solution = MaximumBinaryTree.MonotonicStack()

    "builds both subtrees and preserves the input" {
        val nums = intArrayOf(3, 2, 1, 6, 0, 5)
        val original = nums.copyOf()

        solution.constructMaximumBinaryTree(nums).toLevelOrder() shouldBe
            listOf(6, 3, 5, null, 2, 0, null, null, 1)
        nums shouldBe original
    }

    "decreasing input produces only right children" {
        solution.constructMaximumBinaryTree(intArrayOf(3, 2, 1)).toLevelOrder() shouldBe
            listOf(3, null, 2, null, 1)
    }

    "increasing input produces only left children" {
        solution.constructMaximumBinaryTree(intArrayOf(1, 2, 3)).toLevelOrder() shouldBe
            listOf(3, 2, null, 1)
    }

    "a new right child keeps the displaced subtree as its left child" {
        solution.constructMaximumBinaryTree(intArrayOf(5, 2, 1, 4, 3)).toLevelOrder() shouldBe
            listOf(5, null, 4, 2, 3, null, 1)
    }

    "a single value produces a leaf" {
        solution.constructMaximumBinaryTree(intArrayOf(1000)).toLevelOrder() shouldBe listOf(1000)
    }
})

private fun TreeNode?.toLevelOrder(): List<Int?> {
    val values = mutableListOf<Int?>()
    val queue = ArrayDeque<TreeNode?>()
    queue.addLast(this)
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        values.add(node?.`val`)
        if (node != null) {
            queue.addLast(node.left)
            queue.addLast(node.right)
        }
    }
    return values.dropLastWhile { it == null }
}
