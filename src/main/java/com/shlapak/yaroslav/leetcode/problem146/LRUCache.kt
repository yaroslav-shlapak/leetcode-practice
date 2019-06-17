package com.shlapak.yaroslav.leetcode.problem146

import java.util.*

/**
 * Created on 2019/06/15.
 * https://leetcode.com/problems/lru-cache/
 */
class LRUCache(val capacity: Int) {
    private val head = Node(0, 0)
    private val tail = Node(0, 0)
    private val default = -1
    private val map = mutableMapOf<Int, Node>()

    init {
        head.next = tail
        tail.prev = head
    }

    fun get(key: Int): Int {
        return if (map.containsKey(key)) {
            val node: Node = map.get(key)!!
            remove(node)
            insertToHead(node)
            node.value
        } else {
            default
        }
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            val node: Node = map.get(key)!!
            remove(node)
            node.value = value
            insertToHead(node)
        } else {
            if (map.size == capacity) {
                map.remove(tail.prev?.key)
                remove(tail.prev)
            }

            val n = Node(key, value)
            insertToHead(n)
            map[key] = n
        }
    }

    fun remove(node: Node?) {
        node?.prev?.next = node?.next
        node?.next?.prev = node?.prev
    }

    fun insertToHead(node: Node) {
        val headNext = head.next
        head.next = node
        headNext?.prev = node
        node.prev = head
        node.next = headNext
    }

    override fun toString(): String {
        return map.toString()
    }

    class Node(var key: Int, var value: Int) {
        var prev: Node? = null
        var next: Node? = null
    }
}

class LRUCache2(private val capacity: Int) {
    private val map = object : LinkedHashMap<Int, Int>(capacity, 0.75f, true) {
        override fun removeEldestEntry(eldest: MutableMap.MutableEntry<Int, Int>?): Boolean {
            return size > capacity
        }
    }

    fun get(key: Int): Int {
        return map.getOrDefault(key, -1)
    }

    fun put(key: Int, value: Int) {
        map[key] = value
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */