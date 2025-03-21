package com.shlapak.yaroslav.leetcode.problems101to200.problem146

import com.shlapak.yaroslav.leetcode.problems101to200.problem146.LRUCache
import com.shlapak.yaroslav.leetcode.problems101to200.problem146.LRUCache2
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem146.LRUCache
 **/
class LRUCacheTest : FreeSpec({
    "LRUCache" - {
        val inputs = getInputs()

        for (input in inputs) {
            "input: ${input}" - {
                val lruCache: LRUCache = LRUCache(input.first)
                input.second.asSequence().forEach { action ->
                    "action: $action" {
                        when (action) {
                            is TestAction.GetAction -> {
                                val actual = lruCache.get(action.key)
                                println("actual: ${actual}")
                                println("expected: ${action.result}")
                                actual shouldBe action.result
                            }
                            is TestAction.PutAction -> {
                                lruCache.put(action.key, action.value)
                            }
                        }
                        println("lruCache: ${lruCache}")

                    }
                }
            }
        }
    }

    "LRUCache2" - {
        val inputs = getInputs()

        for (input in inputs) {
            "input: ${input}" - {
                val lruCache: LRUCache2 = LRUCache2(input.first)
                input.second.asSequence().forEach { action ->
                    "action: $action" {
                        when (action) {
                            is TestAction.GetAction -> {
                                val actual = lruCache.get(action.key)
                                println("actual: ${actual}")
                                println("expected: ${action.result}")
                                actual shouldBe action.result
                            }
                            is TestAction.PutAction -> {
                                lruCache.put(action.key, action.value)
                            }
                        }
                        println("lruCache: ${lruCache}")

                    }
                }
            }
        }
    }
})

private sealed class TestAction {
    data class GetAction(
            val key: Int,
            val result: Int
    ) : TestAction()

    data class PutAction(
            val key: Int,
            val value: Int
    ) : TestAction()
}
/*
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
 */

private fun getInputs(): List<Pair<Int, List<TestAction>>> {
    return listOf(
            2 to listOf(
                TestAction.PutAction(key = 1, value = 1),
                TestAction.PutAction(key = 2, value = 2),
                TestAction.GetAction(key = 1, result = 1),
                TestAction.PutAction(key = 3, value = 3),
                TestAction.GetAction(key = 2, result = -1),
                TestAction.PutAction(key = 4, value = 4),
                TestAction.GetAction(key = 1, result = -1),
                TestAction.GetAction(key = 3, result = 3),
                TestAction.GetAction(key = 4, result = 4)
            )
    )
}