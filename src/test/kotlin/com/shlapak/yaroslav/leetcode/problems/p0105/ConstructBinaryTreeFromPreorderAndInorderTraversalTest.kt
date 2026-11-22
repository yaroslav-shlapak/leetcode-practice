package com.shlapak.yaroslav.leetcode.problems.p0105

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [ConstructBinaryTreeFromPreorderAndInorderTraversal.IterativeStack] and
 * [ConstructBinaryTreeFromPreorderAndInorderTraversal.DivideAndConquer] with the examples
 * and skewed trees.
 */
class ConstructBinaryTreeFromPreorderAndInorderTraversalTest : FreeSpec({
    val iterativeStack = ConstructBinaryTreeFromPreorderAndInorderTraversal.IterativeStack()
    val divideAndConquer = ConstructBinaryTreeFromPreorderAndInorderTraversal.DivideAndConquer()
    val approaches = mapOf(
        "iterative stack" to iterativeStack::buildTree,
        "divide and conquer" to divideAndConquer::buildTree
    )

    for ((name, buildTree) in approaches) {
        name - {
            "builds both subtrees and preserves the inputs" {
                val preorder = intArrayOf(3, 9, 20, 15, 7)
                val inorder = intArrayOf(9, 3, 15, 20, 7)
                val originalPreorder = preorder.copyOf()
                val originalInorder = inorder.copyOf()

                val root = requireNotNull(buildTree(preorder, inorder))
                root.`val` shouldBe 3
                val left = requireNotNull(root.left)
                left.`val` shouldBe 9
                left.left shouldBe null
                left.right shouldBe null
                val right = requireNotNull(root.right)
                right.`val` shouldBe 20
                right.left?.`val` shouldBe 15
                right.right?.`val` shouldBe 7
                preorder shouldBe originalPreorder
                inorder shouldBe originalInorder
            }

            "uses separate preorder and inorder starts in a subtree" {
                val preorder = intArrayOf(2, 1, 4, 5, 3, 6)
                val inorder = intArrayOf(4, 1, 5, 2, 3, 6)

                val root = requireNotNull(buildTree(preorder, inorder))
                root.`val` shouldBe 2
                val left = requireNotNull(root.left)
                left.`val` shouldBe 1
                left.left?.`val` shouldBe 4
                left.right?.`val` shouldBe 5
                val right = requireNotNull(root.right)
                right.`val` shouldBe 3
                right.left shouldBe null
                right.right?.`val` shouldBe 6
            }

            "builds a single negative leaf" {
                val root = requireNotNull(buildTree(intArrayOf(-1), intArrayOf(-1)))
                root.`val` shouldBe -1
                root.left shouldBe null
                root.right shouldBe null
            }

            "builds a maximum-length chain of left children" {
                val preorder = IntArray(3000) { it }
                var node = buildTree(preorder, preorder.reversedArray())

                for (value in preorder) {
                    val current = requireNotNull(node)
                    current.`val` shouldBe value
                    current.right shouldBe null
                    node = current.left
                }
                node shouldBe null
            }

            "builds a maximum-length chain of right children" {
                val preorder = IntArray(3000) { it }
                var node = buildTree(preorder, preorder.copyOf())

                for (value in preorder) {
                    val current = requireNotNull(node)
                    current.`val` shouldBe value
                    current.left shouldBe null
                    node = current.right
                }
                node shouldBe null
            }
        }
    }
})
