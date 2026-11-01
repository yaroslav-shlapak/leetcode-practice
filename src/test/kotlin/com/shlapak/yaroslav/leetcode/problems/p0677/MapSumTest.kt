package com.shlapak.yaroslav.leetcode.problems.p0677

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class MapSumTest : FreeSpec({
    val implementations = mapOf<String, () -> MapSumOperations>(
        "default" to { MapSum() },
        "scan" to { MapSum.Scan() },
        "prefix sums" to { MapSum.PrefixSums() },
        "trie" to { MapSum.Trie() }
    )
    implementations.forEach { (name, create) ->
        "$name sums shared prefixes and replaces existing values" {
            val map = create()
            map.sum("ap") shouldBe 0
            map.insert("apple", 3)
            map.sum("ap") shouldBe 3
            map.insert("app", 2)
            map.sum("ap") shouldBe 5
            map.insert("apple", 1)
            map.sum("app") shouldBe 3
            map.sum("apple") shouldBe 1
            map.insert("app", 5)
            map.sum("ap") shouldBe 6
            map.sum("apples") shouldBe 0
            map.sum("") shouldBe 6
        }
    }
})
