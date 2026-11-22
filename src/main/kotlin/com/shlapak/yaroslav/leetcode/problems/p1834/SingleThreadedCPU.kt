package com.shlapak.yaroslav.leetcode.problems.p1834

import java.util.PriorityQueue

/**
 * LeetCode 1834: Single-Threaded CPU.
 *
 * Returns the order in which a CPU processes tasks by availability and processing time.
 *
 * @see <a href="https://leetcode.com/problems/single-threaded-cpu/">Problem statement</a>
 */
class SingleThreadedCPU {
    /**
     * Sorts tasks by enqueue time and selects available tasks using a priority queue.
     * Ties in processing time are broken by original index. The input is not modified.
     * The Int clock can overflow only after all tasks have been enqueued: enqueue times and
     * processing times are at most 1 billion, so the first completion cannot overflow, and
     * any later overflow occurs after time 1 billion. The queue then determines the rest.
     *
     * Time: O(n log n), where n is the number of tasks.
     * Space: O(n), including the result, task copies, queue, and sorting workspace.
     */
    class PriorityQueueSimulation {
        private data class Task(val enqTime: Int, val procTime: Int, val idx: Int)

        fun getOrder(tasks: Array<IntArray>): IntArray {
            val tsks = tasks.mapIndexed { i, task -> Task(task[0], task[1], i) }.toMutableList()
            tsks.sortBy { it.enqTime }
            val minHeap = PriorityQueue<Task>(compareBy<Task> { it.procTime }.thenBy { it.idx })
            var curTime = 0
            var i = 0
            val res = IntArray(tsks.size)
            var resIdx = 0

            while (resIdx < tsks.size) {
                while (i < tsks.size && tsks[i].enqTime <= curTime) {
                    minHeap.add(tsks[i])
                    i++
                }

                if (minHeap.isEmpty()) {
                    curTime = tsks[i].enqTime
                } else {
                    val task = minHeap.poll()
                    curTime += task.procTime
                    res[resIdx++] = task.idx
                }
            }
            return res
        }
    }
}
