package com.shlapak.yaroslav.leetcode.problems.p0981

import java.util.*
import kotlin.collections.HashMap

/**
 * LeetCode 981: Time Based Key Value Store.
 *
 * Stores timestamped values and retrieves the latest value at or before a timestamp.
 *
 * @see <a href="https://leetcode.com/problems/time-based-key-value-store/">Problem statement</a>
 */
class TimeMap() {
    private val map = HashMap<String, TreeMap<Int, String>>()

    fun set(key: String, value: String, timestamp: Int) {
        val tree = map.getOrPut(key) { TreeMap() }
        tree[timestamp] = value
    }

    fun get(key: String, timestamp: Int): String {
        val tree = map[key] ?: return ""
        // Returns a key-value mapping associated with the greatest key less than or equal to the given key,
        // or null if there is no such key.
        val entry = tree.floorEntry(timestamp) ?: return ""
        return entry.value
    }
}

class TimeMap2() {
    class TimeValue(val timestamp: Int, val value: String)

    private val timeMap = mutableMapOf<String, MutableList<TimeValue>>()

    fun set(key: String, value: String, timestamp: Int) {
        val timeValues: MutableList<TimeValue> = timeMap.getOrDefault(key, mutableListOf())
        timeValues.add(TimeValue(timestamp, value))
        timeMap[key] = timeValues
    }

    fun get(key: String, timestamp: Int): String {
        var result = ""
        val timeValues: MutableList<TimeValue> = timeMap.get(key) ?: return result
        var left = 0
        var right = timeValues.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            if (timeValues[mid].timestamp <= timestamp) {
                result = timeValues[mid].value
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return result
    }
}
