package com.shlapak.yaroslav.leetcode.problem146

import java.util.*

/**
 * Created on 2019/06/15.
 * https://leetcode.com/problems/lru-cache/
 */
class LRUCache(val capacity: Int) {
    private val leastUsed = LinkedList<Int>()
    private val map = mutableMapOf<Int, Int>()

    fun get(key: Int): Int {
        return map.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        if (!map.containsKey(key)) {
            if (map.size >= capacity) {
                val first = leastUsed.pollFirst()
                map.remove(first)
            }
            map.put(key, value)
            leastUsed.addLast(value)
        }
    }

    override fun toString(): String {
        return map.toString()
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */