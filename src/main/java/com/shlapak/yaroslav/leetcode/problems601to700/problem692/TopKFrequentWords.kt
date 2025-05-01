package com.shlapak.yaroslav.leetcode.problems601to700.problem692

import java.util.Comparator
import java.util.PriorityQueue


class TopKFrequentWords {
    fun topKFrequent(words: Array<String>, k: Int): List<String> {
        val freqMap = HashMap<String, Int>()

        for (word in words) {
            freqMap[word] = (freqMap[word] ?: 0) + 1
        }

        val maxHeap = PriorityQueue<Pair<String, Int>>(freqMap.size) { o1, o2 ->
            val (word1, freq1) = o1
            val (word2, freq2) = o2
            if (freq1 - freq2 == 0) { // same frequency
                word1.compareTo(word2) // Sort the words with the same frequency by their lexicographical order.
            } else {
                freq2.compareTo(freq1) //  sorted by the frequency from highest to lowest
            }
        }

        freqMap.forEach { (word, freq) ->
            maxHeap.offer(word to freq)
        }

        val res = mutableListOf<String>()
        for (i in 0 until maxHeap.size.coerceAtMost(k)) {
            res.add(maxHeap.poll().first)
        }

        return res
    }

    fun topKFrequent2(words: Array<String>, k: Int): List<String> {
        val freqMap: Map<String, Int> = words.groupingBy { it }.eachCount()

        val heap = PriorityQueue<Pair<String, Int>>(
            words.size,
            compareByDescending<Pair<String, Int>> { it.second }.thenBy { it.first } as Comparator<in Pair<String, Int>>?
        )

        freqMap.forEach { heap.add(it.key to it.value) }

        return List(k) { heap.poll().first }
    }

}