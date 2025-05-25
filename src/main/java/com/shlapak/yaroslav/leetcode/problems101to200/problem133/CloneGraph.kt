package com.shlapak.yaroslav.leetcode.problems101to200.problem133

import com.shlapak.yaroslav.leetcode.utils.Node

class CloneGraph {
    fun cloneGraph(node: Node?): Node? {
        // This map keeps track of already copied nodes
        // Key: original node, Value: cloned node
        val oldToNew = mutableMapOf<Node, Node>()

        // DFS helper function to clone the graph
        fun dfs(node: Node?): Node? {
            // Base case: null node, return null
            if (node == null) return null

            // If the node was already copied, return the copy from the map
            val nodeInMap = oldToNew[node]
            return if (nodeInMap != null) {
                nodeInMap
            } else {
                // Otherwise, create a copy of the node
                val newNode = Node(node.`val`)
                // Save it in the map before processing neighbors (important for cyclic graphs)
                oldToNew[node] = newNode

                // Recursively copy all neighbors and add them to the new node
                for (nei in node.neighbors) {
                    newNode.neighbors.add(dfs(nei))
                }

                // Return the cloned node
                newNode
            }
        }

        // Start DFS from the given node
        return dfs(node)
    }
}

class SolutionIterativeBFS {
    fun cloneGraph(node: Node?): Node? {
        // use BFS to traverse the graph
        // use map to identify if the node has already been copied
        // If the input node is null, return null (nothing to clone)
        if (node == null) return node

        // This map stores already cloned nodes
        // Key: original node, Value: cloned node
        val oldToNew = mutableMapOf<Node, Node>()

        // Create a copy of the starting node and put it in the map
        oldToNew[node] = Node(node.`val`)

        // Queue for BFS traversal
        val queue = ArrayDeque<Node>()
        queue.addLast(node)

        // Start BFS
        while (queue.isNotEmpty()) {
            val oldNode = queue.removeFirst()

            // Iterate through each neighbor of the current node
            for (nei in oldNode.neighbors) {
                nei!!
                // If the neighbor hasn't been copied yet
                if (oldToNew[nei] == null) {
                    // Create a copy and add it to the map
                    val newNode = Node(`val` = nei.`val`)
                    oldToNew[nei] = newNode
                    // Add the neighbor to the queue to process its neighbors later
                    queue.addLast(nei)
                }

                // Link the copy of the current node to the copy of the neighbor
                oldToNew[oldNode]?.neighbors?.add(oldToNew[nei]!!)
            }
        }

        // Return the clone of the input node
        return oldToNew[node]
    }
}