package com.shlapak.yaroslav.leetcode.problems901to1000.problem997

class FindTheTownJudge {
    class TwoMaps {
        fun findJudge(n: Int, trust: Array<IntArray>): Int {
            if (trust.isEmpty() && n == 1) return 1
            val idToTrusted = mutableMapOf<Int, Int>()
            val idToTrustee = mutableMapOf<Int, Int>()
            var maxTrustee = 0
            var label = -1
            for (t in trust) {
                idToTrusted[t[0]] = idToTrusted.getOrPut(t[0]) { 0 } + 1
                idToTrustee[t[1]] = idToTrustee.getOrPut(t[1]) { 0 } + 1
                val size = idToTrustee[t[1]]!!
                if (size > maxTrustee) {
                    maxTrustee = size
                    label = t[1]
                }
            }
            return if (idToTrusted[label] == null && idToTrustee[label] == n - 1) label else -1
        }
    }

    class TwoMaps2 {
        fun findJudge(n: Int, trust: Array<IntArray>): Int {
            if (trust.isEmpty() && n == 1) return 1
            val idToTrusted = mutableMapOf<Int, Int>()
            val idToTrustee = mutableMapOf<Int, Int>()
            for (t in trust) {
                idToTrusted[t[0]] = idToTrusted.getOrPut(t[0]) { 0 } + 1
                idToTrustee[t[1]] = idToTrustee.getOrPut(t[1]) { 0 } + 1
            }
            for (i in 1..n) {
                if (idToTrusted[i] == null && idToTrustee[i] == n - 1) return i
            }
            return -1
        }
    }

    class TwoMaps3 {
        fun findJudge(n: Int, trust: Array<IntArray>): Int {
            if (trust.isEmpty() && n == 1) return 1
            val idToTrusted = mutableMapOf<Int, MutableList<Int>>()
            val idToTrustee = mutableMapOf<Int, MutableList<Int>>()
            var maxTrustee = 0
            var label = -1
            for (t in trust) {
                idToTrusted.getOrPut(t[0]) { mutableListOf() }.add(t[1])
                idToTrustee.getOrPut(t[1]) { mutableListOf() }.add(t[0])
                val size = idToTrustee[t[1]]!!.size
                if (size > maxTrustee) {
                    maxTrustee = size
                    label = t[1]
                }
            }
            return if (idToTrusted[label] == null && idToTrustee[label]?.size == n - 1) label else -1
        }
    }

    class TwoArrays {
        fun findJudge(n: Int, trust: Array<IntArray>): Int {
            if (trust.isEmpty() && n == 1) return 1
            val trusted = IntArray(n + 1)
            val trustee = IntArray(n + 1)
            for (t in trust) {
                trusted[t[0]]++
                trustee[t[1]]++
            }
            for (i in 1..n) {
                if (trusted[i] == 0 && trustee[i] == n - 1) return i
            }
            return -1
        }
    }
}