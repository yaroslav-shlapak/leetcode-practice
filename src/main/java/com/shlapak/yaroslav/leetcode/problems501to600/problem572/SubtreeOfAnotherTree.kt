package com.shlapak.yaroslav.leetcode.problems501to600.problem572

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 572. Subtree of Another Tree
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
class SubtreeOfAnotherTree {
    class DfsAndBfs {
        fun isSubtree(root: TreeNode?, subRoot: TreeNode): Boolean {
            var isSubtreeFound = false
            fun dfs(node: TreeNode?) {
                if (isSubtreeFound) return
                if (node == null) return
                isSubtreeFound = sameTree(node, subRoot)
                node.left?.let {
                    dfs(it)
                }
                node.right?.let {
                    dfs(it)
                }
            }

            dfs(root)

            return isSubtreeFound
        }

        fun sameTree(node1: TreeNode, node2: TreeNode): Boolean {
            val queue1 = ArrayDeque<Pair<TreeNode, Char>>()
            val queue2 = ArrayDeque<Pair<TreeNode, Char>>()

            queue1.addLast(node1 to 'l')
            queue2.addLast(node2 to 'l')

            while (queue1.isNotEmpty() || queue2.isNotEmpty()) {
                val len1 = queue1.size
                val len2 = queue2.size
                if (len1 != len2) return false
                repeat(len1) {
                    val (n1, s1) = queue1.removeFirst()
                    val (n2, s2) = queue2.removeFirst()
                    if (n1.`val` != n2.`val` || s1 != s2) return false
                    n1.left?.let {
                        queue1.addLast(it to 'l')
                    }
                    n1.right?.let {
                        queue1.addLast(it to 'r')
                    }
                    n2.left?.let {
                        queue2.addLast(it to 'l')
                    }
                    n2.right?.let {
                        queue2.addLast(it to 'r')
                    }
                }
            }

            return true
        }
    }

    class DfsOnly {
        fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
            var res = false

            fun checkTheSame(node1: TreeNode?, node2: TreeNode?) : Boolean {
                if (node1?.`val` != node2?.`val`) return false
                if (node2 == null || node1 == null) return true

                return checkTheSame(node1.left, node2.left) && checkTheSame(node1.right, node2.right)
            }

            fun findFirstMatch(node: TreeNode?) {
                if (node == null) return
                if (res == true) return
                if (node?.`val` == subRoot?.`val` && node != null) {
                    res = checkTheSame(node, subRoot)
                }
                findFirstMatch(node?.left)
                findFirstMatch(node?.right)
            }
            findFirstMatch(root)


            return res
        }
    }
}