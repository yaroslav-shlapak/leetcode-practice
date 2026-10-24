package com.shlapak.yaroslav.leetcode.common

import java.util.ArrayList

/**
 * Mutable graph node using LeetCode's value naming.
 *
 * @property `val` Value stored in this node.
 * @property neighbors Adjacent nodes; entries may be null.
 */
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList<Node?>()
}
