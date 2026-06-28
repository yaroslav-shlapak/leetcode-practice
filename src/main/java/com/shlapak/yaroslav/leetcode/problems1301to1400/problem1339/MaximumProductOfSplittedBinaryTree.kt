package com.shlapak.yaroslav.leetcode.problems1301to1400.problem1339

import com.shlapak.yaroslav.leetcode.utils.TreeNode

/**
 * 1339. Maximum Product of Splitted Binary Tree
 *
 * https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/description/
 */
private const val MOD = 1_000_000_007

class MaximumProductOfSplittedBinaryTree {
    class Dfs2Simpler {
        fun maxProduct(root: TreeNode?): Int {
            fun dfs1(node: TreeNode?): Long {
                if (node == null) return 0
                return dfs1(node.left) + dfs1(node.right) + node.`val`.toLong()
            }

            val totSum = dfs1(root)
            var max = 0L

            fun dfs2(node: TreeNode?): Long {
                if (node == null) return 0
                val c = node.`val`.toLong()
                val l = dfs2(node.left)
                val r = dfs2(node.right)
                val downStreamSum = c + l + r
                val p = totSum - downStreamSum
                max = maxOf(max, downStreamSum * p)

                return downStreamSum
            }

            dfs2(root)

            return (max % MOD).toInt()
        }
    }

    class Dfs1 {
        fun maxProduct(root: TreeNode?): Int {
            fun dfs1(node: TreeNode?): Long {
                if (node == null) return 0
                return dfs1(node.left) + dfs1(node.right) + node.`val`.toLong()
            }

            val totSum = dfs1(root)

            var max = 0L

            fun dfs2(node: TreeNode?): Long {
                if (node == null) return 0
                val c = node.`val`.toLong()
                val l = dfs2(node.left)
                val r = dfs2(node.right)
                val p = totSum - c - l - r
                max = maxOf(max, (l + c + p) * r)
                max = maxOf(max, l * (r + c + p))

                return c + l + r
            }

            dfs2(root)

            return (max % MOD).toInt()
        }
    }
}