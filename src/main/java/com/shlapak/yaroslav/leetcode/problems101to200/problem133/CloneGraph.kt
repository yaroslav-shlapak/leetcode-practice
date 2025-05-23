package com.shlapak.yaroslav.leetcode.problems101to200.problem133

import com.shlapak.yaroslav.leetcode.utils.Node

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        val oldToNew = mutableMapOf<Node, Node>()

        fun dfs(node: Node?): Node? {
            if (node == null) return null
            val nodeInMap = oldToNew[node]
            return if (nodeInMap != null) {
                nodeInMap
            } else {
                val newNode = Node(node.`val`)
                oldToNew[node] = newNode
                for (nei in node.neighbors) {
                    newNode.neighbors.add(dfs(nei))
                }
                newNode
            }
        }

        return dfs(node)
    }
}