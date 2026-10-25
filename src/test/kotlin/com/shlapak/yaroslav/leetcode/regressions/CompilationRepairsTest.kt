package com.shlapak.yaroslav.leetcode.regressions

import com.shlapak.yaroslav.leetcode.common.TreeNode
import com.shlapak.yaroslav.leetcode.problems.p0006.ZigZagConversion
import com.shlapak.yaroslav.leetcode.problems.p0086.PartitionList
import com.shlapak.yaroslav.leetcode.problems.p0114.FlattenBinaryTreeToLinkedList
import com.shlapak.yaroslav.leetcode.problems.p0165.CompareVersionNumbers
import com.shlapak.yaroslav.leetcode.problems.p0208.ImplementTrie
import com.shlapak.yaroslav.leetcode.problems.p0226.InvertBinaryTreeIterative
import com.shlapak.yaroslav.leetcode.problems.p0328.OddEvenLinkedList
import com.shlapak.yaroslav.leetcode.problems.p0623.AddOneRowToTree
import com.shlapak.yaroslav.leetcode.problems.p0648.ReplaceWords
import com.shlapak.yaroslav.leetcode.problems.p0670.MaxSwap
import com.shlapak.yaroslav.leetcode.problems.p0814.BinaryTreePruning
import com.shlapak.yaroslav.leetcode.problems.p0904.FruitIntoBuckets
import com.shlapak.yaroslav.leetcode.problems.p1448.CountGoodNodesInBinaryTree
import com.shlapak.yaroslav.leetcode.problems.p1534.CountGoodTriplets
import com.shlapak.yaroslav.leetcode.problems.p1855.MaximumDistanceBetweenAPairOfValues
import com.shlapak.yaroslav.leetcode.problems.p2130.MaximumTwinSumOfALinkedList
import com.shlapak.yaroslav.leetcode.problems.p3075.MaximizeHappinessOfSelectedChildren
import com.shlapak.yaroslav.leetcode.support.toIntList
import com.shlapak.yaroslav.leetcode.support.toListNode
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Exercises solutions that previously prevented the entire repository from compiling.
 * Uses observable results to guard the repaired declarations, imports, and node handling.
 */
class CompilationRepairsTest : FreeSpec({
    "zigzag implementations handle changing directions" {
        ZigZagConversion.DirectionalApproach().convert("PAYPALISHIRING", 3) shouldBe "PAHNAPLSIIGYIR"
        ZigZagConversion.Solution().convert("PAYPALISHIRING", 4) shouldBe "PINALSIGYAHRPI"
    }

    "partitioning preserves node order in each group" {
        val head = listOf(1, 4, 3, 2, 5, 2).toListNode()
        PartitionList().partition(head, 3).toIntList() shouldBe listOf(1, 2, 2, 4, 3, 5)
        PartitionList().partition(null, 3) shouldBe null
    }

    val flatteners: Map<String, (TreeNode?) -> Unit> = mapOf(
        "recursive tails" to FlattenBinaryTreeToLinkedList.RecursiveUnderstandable()::flatten,
        "reverse preorder" to FlattenBinaryTreeToLinkedList.Recursive()::flatten,
        "recursive rewiring" to FlattenBinaryTreeToLinkedList.Recursive2()::flatten,
        "iterative rewiring" to FlattenBinaryTreeToLinkedList.Iterative()::flatten,
        "stack" to FlattenBinaryTreeToLinkedList.StackBased()::flatten,
    )
    for ((name, flatten) in flatteners) {
        "flatten $name" {
            val root = TreeNode(1).apply {
                left = TreeNode(2).apply { left = TreeNode(3); right = TreeNode(4) }
                right = TreeNode(5).apply { right = TreeNode(6) }
            }
            flatten(root)
            val actual = mutableListOf<Int>()
            var current: TreeNode? = root
            while (current != null && actual.size <= 6) {
                val node = current ?: break
                node.left shouldBe null
                actual.add(node.`val`)
                current = node.right
            }
            actual shouldBe listOf(1, 2, 3, 4, 5, 6)
            current shouldBe null
        }
    }

    "version comparison ignores leading and trailing zeros" {
        val solution = CompareVersionNumbers.Solution()
        solution.compareVersion("1.01", "1.001") shouldBe 0
        solution.compareVersion("1.0.0", "1") shouldBe 0
        solution.compareVersion("0.1", "1.1") shouldBe -1
        solution.compareVersion("1.2", "1.1") shouldBe 1
    }

    "both tries distinguish complete words from prefixes" {
        val first = ImplementTrie.Solution1.Trie()
        first.insert("apple")
        first.search("apple") shouldBe true
        first.search("app") shouldBe false
        first.startsWith("app") shouldBe true
        first.insert("app")
        first.search("app") shouldBe true
        val second = ImplementTrie.Solution2.Trie()
        second.insert("apple")
        second.search("apple") shouldBe true
        second.search("app") shouldBe false
        second.startsWith("app") shouldBe true
        second.startsWith("bad") shouldBe false
    }

    "iterative inversion swaps children at every level" {
        val root = TreeNode(1).apply {
            left = TreeNode(2).apply { left = TreeNode(4) }
            right = TreeNode(3)
        }
        val result = InvertBinaryTreeIterative().invertTree(root)
        result?.left?.`val` shouldBe 3
        result?.right?.`val` shouldBe 2
        result?.right?.right?.`val` shouldBe 4
    }

    "odd-even grouping terminates and preserves relative order" {
        OddEvenLinkedList().oddEvenList(listOf(1, 2, 3, 4, 5).toListNode()).toIntList() shouldBe
            listOf(1, 3, 5, 2, 4)
        OddEvenLinkedList().oddEvenList(null) shouldBe null
        OddEvenLinkedList().oddEvenList(listOf(1).toListNode()).toIntList() shouldBe listOf(1)
    }

    "inserting a tree row retains the original subtrees" {
        val root = TreeNode(4).apply { left = TreeNode(2); right = TreeNode(6) }
        val result = AddOneRowToTree.Bfs().addOneRow(root, 1, 2)
        result?.left?.`val` shouldBe 1
        result?.left?.left?.`val` shouldBe 2
        result?.right?.`val` shouldBe 1
        result?.right?.right?.`val` shouldBe 6
    }

    "word replacement chooses the shortest matching root" {
        ReplaceWords.Trie().replaceWords(listOf("cat", "bat", "rat"), "the cattle was rattled by the battery") shouldBe
            "the cat was rat by the bat"
        ReplaceWords.Trie().replaceWords(listOf("a", "aa"), "aaa xyz") shouldBe "a xyz"
    }

    "maximum swap handles repeated maximum digits and already maximal numbers" {
        for (solve in listOf(MaxSwap()::maximumSwap1, MaxSwap()::maximumSwap2)) {
            solve(2736) shouldBe 7236
            solve(9973) shouldBe 9973
            solve(1993) shouldBe 9913
        }
    }

    "pruning removes only subtrees without ones" {
        for (prune in listOf(BinaryTreePruning.Dfs()::pruneTree, BinaryTreePruning.Dfs2()::pruneTree)) {
            val root = TreeNode(1).apply { left = TreeNode(0); right = TreeNode(1) }
            val result = prune(root)
            result?.left shouldBe null
            result?.right?.`val` shouldBe 1
            prune(TreeNode(0)) shouldBe null
        }
    }

    "fruit windows handle changing types and uniform input" {
        val solution = FruitIntoBuckets()
        for (solve in listOf(solution::totalFruit, solution::totalFruit2, solution::totalFruit3, solution::totalFruit4)) {
            solve(intArrayOf(1, 2, 1)) shouldBe 3
            solve(intArrayOf(0, 1, 2, 2)) shouldBe 3
            solve(intArrayOf(1, 2, 3, 2, 2)) shouldBe 4
            solve(intArrayOf(1, 1, 1)) shouldBe 3
        }
    }

    "good-node counts agree for breadth-first and depth-first traversal" {
        val root = TreeNode(3).apply {
            left = TreeNode(1).apply { left = TreeNode(3) }
            right = TreeNode(4).apply { left = TreeNode(1); right = TreeNode(5) }
        }
        CountGoodNodesInBinaryTree.Dfs().goodNodes(root) shouldBe 4
        CountGoodNodesInBinaryTree.Bfs().goodNodes(root) shouldBe 4
    }

    "good triplets obey all three distance bounds" {
        CountGoodTriplets().countGoodTriplets(intArrayOf(3, 0, 1, 1, 9, 7), 7, 2, 3) shouldBe 4
        CountGoodTriplets().countGoodTriplets(intArrayOf(1, 1, 2, 2, 3), 0, 0, 1) shouldBe 0
    }

    "maximum distance respects array bounds and index order" {
        val first = intArrayOf(55, 30, 5, 4, 2)
        val second = intArrayOf(100, 20, 10, 10, 5)
        MaximumDistanceBetweenAPairOfValues.TwoPointers().maxDistance(first, second) shouldBe 2
        MaximumDistanceBetweenAPairOfValues.TwoPointers2().maxDistance(first, second) shouldBe 2
    }

    "twin sums compare mirrored nodes without changing the list" {
        val head = listOf(5, 4, 2, 1).toListNode()
        MaximumTwinSumOfALinkedList.ArrayValues().pairSum(head) shouldBe 6
        head.toIntList() shouldBe listOf(5, 4, 2, 1)
        MaximumTwinSumOfALinkedList.ArrayValues().pairSum(listOf(4, 2, 2, 3).toListNode()) shouldBe 7
    }

    "happiness selection stops when remaining contributions reach zero" {
        MaximizeHappinessOfSelectedChildren().maximumHappinessSum(intArrayOf(1, 2, 3), 2) shouldBe 4L
        MaximizeHappinessOfSelectedChildren().maximumHappinessSum(intArrayOf(1, 1, 1, 1), 4) shouldBe 1L
    }
})
