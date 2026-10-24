package com.shlapak.yaroslav.leetcode.problems.p0015

/**
 * LeetCode 15: 3Sum.
 *
 * Finds unique triplets whose sum is zero.
 *
 * @see <a href="https://leetcode.com/problems/3sum/">Problem statement</a>
 */
class ThreeSum {
    /**
     * Attempts a two-pointer search after sorting [nums] in place.
     *
     * Incomplete: negative sums do not advance either pointer, and duplicate skipping
     * can access beyond the end of the array. Use another implementation for results.
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            if (nums[i] > 0) {
                break
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }

            var l = i + 1
            var r = nums.size - 1
            while (r > l) {
                val threeSum = nums[i] + nums[l] + nums[r]
                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l--
                    else -> {
                        res.add(listOf(nums[i], nums[l], nums[r]))

                        while (r > l && nums[r] == nums[r + 1]) {
                            r--
                        }
                    }
                }
            }
        }

        return res
    }
}

class ThreeSum2 {
    /**
     * Sorts [nums] in place and searches for each triplet's remaining pair with two pointers.
     *
     * Skips repeated values so the result contains distinct triplets.
     *
     * Time: O(n²).
     * Space: O(1) auxiliary space, excluding sorting workspace and the result.
     */
    fun threeSum(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        nums.sort()

        for (i in nums.indices) {
            val a = nums[i]
            if (a > 0) break
            if (i > 0 && a == nums[i - 1]) continue

            var l = i + 1
            var r = nums.size - 1
            while (l < r) {
                val threeSum = a + nums[l] + nums[r]
                when {
                    threeSum > 0 -> r--
                    threeSum < 0 -> l++
                    else -> {
                        res.add(listOf(a, nums[l], nums[r]))
                        l++
                        r--
                        while (l < r && nums[l] == nums[l - 1]) {
                            l++
                        }
                    }
                }
            }
        }

        return res
    }
}
/*
Input
nums =
[2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10]
Output
[[-4,2,2],[-3,-2,5],[-2,0,2],[-5,0,5],[-10,5,5]]
Expected
[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
 */



class ThreeSumLegacy {
    fun threeSumNaive(nums: IntArray): List<List<Int>> {
        val set = mutableSetOf<String>()
        val res = mutableListOf<List<Int>>()
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
                for (k in j + 1 until nums.size) {

                    if (nums[i] + nums[j] + nums[k] == 0) {
                        val l = listOf(nums[i], nums[j], nums[k])
                        val sorted = l.sorted()
                        val s = sorted.toString()
                        if (!set.contains(s)) {
                            set.add(s)
                            res.add(sorted)
                        }
                    }
                }
            }
        }
        return res
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) {
            return emptyList()
        }

        nums.sort()

        val map = nums.mapIndexed { index: Int, i: Int ->
            i to index
        }.toMap()
        val res = mutableSetOf<List<Int>>()

        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val comp = 0 - (nums[i] + nums[j])
                if (map.contains(comp) && map[comp] != i && map[comp] != j) {
                    res.add(listOf(comp, nums[i], nums[j]))
                }
            }
        }

        return res.toList()
    }

}
