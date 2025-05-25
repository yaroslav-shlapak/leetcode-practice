package com.shlapak.yaroslav.leetcode.problems201to300.problem207

/**
 * 207. Course Schedule
 * https://leetcode.com/problems/course-schedule/
 */
class CourseSchedule {
    fun canFinishRecursive(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // we can start at any point
        // but it's better to start from the course that has the most of prerequsistes
        // can we store all courses into the map as keys and their prerequisites into the list
        // we need some algoritms that cheks if there is a cycle
        // we need to take into account that the cycle can contain multiple courses
        val map = HashMap<Int, MutableList<Int>>()
        for (course in 0 until numCourses) {
            map[course] = mutableListOf()
        }
        for ((first, second) in prerequisites) {
            map[first]?.add(second)
        }

        val visited = mutableSetOf<Int>()

        // dfs function to check if the course is completable
        fun dfs(course: Int): Boolean {
            if (course in visited) {
                // cycle detected
                return false
            }
            if (map[course]!!.isEmpty()) {
                // course is completable
                return true
            }
            visited.add(course)
            // iterate over childern to find cycles
            for (child in map[course]!!) {
                if (!dfs(child)) {
                    return false
                }
            }
            // remove from visited
            visited.remove(course)
            // as all children are completable at this point
            // we can say the course is completable as well
            map[course] = mutableListOf()
            return true
        }


        // iterate over all courses to ensure all components of the graph are visited
        for (course in 0 until numCourses) {
            if (!dfs(course)) {
                return false
            }
        }


        return true
    }

    fun canFinishIterative(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // Build preMap: course -> list of its prerequisites
        // preMap[crs] contains a list of courses that must be taken BEFORE crs.
        // So, if [a,b] in prerequisites means 'b' is a prerequisite for 'a',
        // then preMap[a] will store 'b'.
        val preMap = HashMap<Int, MutableList<Int>>()
        for (i in 0 until numCourses) {
            preMap[i] = mutableListOf()
        }
        // In prerequisites, typically [course, prerequisite].
        // If entry is [crs, pre], it means 'pre' is a prerequisite for 'crs'.
        for (prereqArray in prerequisites) {
            val crs = prereqArray[0] // The course
            val pre = prereqArray[1] // The prerequisite for 'crs'
            preMap[crs]!!.add(pre)   // Course 'crs' depends on 'pre'
        }

        // nodeStates:
        // 0: Unvisited
        // 1: Visiting (currently in the iteration path, similar to recursive 'visiting' set)
        // 2: Visited (all prerequisites processed, and no cycle found via this node for this path)
        val nodeStates = IntArray(numCourses) // Initialized to 0 (Unvisited)

        // Iterate through each course to ensure all components of the graph are visited
        for (i in 0 until numCourses) {
            if (nodeStates[i] == 0) { // If course 'i' is Unvisited
                // Start an iterative DFS from course 'i'
                // The callStack stores pairs of (course, nextPrerequisiteIndexToVisit)
                // This simulates the recursion call stack.
                val callStack = ArrayDeque<Pair<Int, Int>>()

                callStack.addLast(Pair(i, 0)) // Push initial course with its first prereq index
                nodeStates[i] = 1             // Mark as Visiting

                while (callStack.isNotEmpty()) {
                    // Peek at the top of the stack to see current course and its state
                    val (currentCourse, prereqIndex) = callStack.last()

                    val prerequisitesOfCurrent = preMap[currentCourse]!! // Safe due to initialization

                    if (prereqIndex < prerequisitesOfCurrent.size) {
                        // This course still has prerequisites to process
                        val nextPrereq = prerequisitesOfCurrent[prereqIndex]

                        // IMPORTANT: Before processing the child (nextPrereq),
                        // update the parent's (currentCourse) state on the stack.
                        // This ensures that when we eventually return to currentCourse (i.e., it's at the
                        // top of the stack again after its children are processed),
                        // we continue with its *next* prerequisite.
                        callStack.removeLast() // Remove old state (currentCourse, prereqIndex)
                        callStack.addLast(Pair(currentCourse, prereqIndex + 1)) // Push updated state

                        if (nodeStates[nextPrereq] == 1) {
                            // Cycle detected: trying to visit a 'nextPrereq' that is already
                            // in the current 'Visiting' path (i.e., an ancestor).
                            return false
                        }

                        if (nodeStates[nextPrereq] == 0) {
                            // If the 'nextPrereq' is Unvisited, mark it as Visiting
                            // and add it to the stack to be processed.
                            nodeStates[nextPrereq] = 1
                            callStack.addLast(Pair(nextPrereq, 0)) // Start with its first prereq
                        }
                        // If nodeStates[nextPrereq] == 2, it means this prerequisite and its
                        // own prerequisite chain have already been processed and found to be acyclic.
                        // So, we can safely skip it and proceed to currentCourse's next prerequisite.
                    } else {
                        // All prerequisites of 'currentCourse' have been processed (or it had none).
                        // This is analogous to the point after the loop in your recursive DFS,
                        // just before removing from 'visiting' and clearing 'preMap' for the course.
                        callStack.removeLast()        // Pop 'currentCourse' from stack
                        nodeStates[currentCourse] = 2 // Mark as fully Visited and acyclic
                        // This mimics visiting.remove(crs) and preMap[crs].clear()
                    }
                }
            }
            // If nodeStates[i] becomes 1 outside the main while loop for 'i',
            // it would imply an issue, but the logic should ensure nodes started as 0
            // either become 2 or cause an early 'return false'.
        }

        return true // All courses processed, no cycles found
    }

    fun canFinish2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // we can start at any point
        // but it's better to start from the course that has the most of prerequsistes
        // can we store all courses into the map as keys and their prerequisites into the list
        // we need some algoritms that cheks if there is a cycle
        // we need to take into account that the cycle can contain multiple courses
        val map = HashMap<Int, MutableList<Int>>()
        for ((first, second) in prerequisites) {
            map.getOrPut(first) { mutableListOf() }.add(second)
            map.getOrPut(second) { mutableListOf() }
        }

        for (entry in map) {
            val (node, children) = entry
            val stack = ArrayDeque<Int>()
            children.forEach {
                val visited = mutableSetOf<Int>(node)
                stack.addFirst(it)
                while (stack.isNotEmpty()) {
                    val n = stack.removeFirst()
                    if (visited.contains(n)) {
                        println("visited: ${visited.toList()}")
                        println("stack: ${stack.toList()}")
                        println("node: $n")
                        return false
                    } else {
                        visited.add(n)
                    }
                    for (child in map[n]!!) {
                        stack.addFirst(child)
                    }
                }
            }
        }

        return map.size <= numCourses
    }
}