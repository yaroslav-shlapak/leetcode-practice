package com.shlapak.yaroslav.leetcode.problems201to300.problem257

import com.shlapak.yaroslav.leetcode.utils.TreeNode

class BinaryTreePaths {
    fun binaryTreePaths(root: TreeNode?): List<String> {
        val res = mutableListOf<String>()
        val path = mutableListOf<Int>()
        fun dfs(node: TreeNode?) {
            if (node == null) {
                return
            }
            if (node.right == null && node.left == null) {
                path.add(node.`val`)
                val str = StringBuilder()
                for (i in path) {
                    if (!str.isEmpty()) {
                        str.append("->")
                    }
                    str.append(i)
                }
                path.removeLast()
                res.add(str.toString())
                println(res)
                return
            }

            path.add(node.`val`)
            dfs(node.left)
            dfs(node.right)
            path.removeLast()
        }

        dfs(root)

        return res
    }

    fun binaryTreePaths1(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()
        if (root == null) return result

        fun dfs(node: TreeNode?, path: String) {
            if (node == null) return

            val newPath = if (path.isEmpty()) "${node.`val`}" else "$path->${node.`val`}"

            if (node.left == null && node.right == null) {
                result.add(newPath)
            } else {
                dfs(node.left, newPath)
                dfs(node.right, newPath)
            }
        }

        dfs(root, "")
        return result
    }

}