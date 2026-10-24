package com.shlapak.yaroslav.leetcode.problems.p0015

import com.google.gson.Gson
import com.shlapak.yaroslav.leetcode.support.asString
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainAll

/**
 * Tests [ThreeSumLegacy].
 *
 * Loads larger input and expected-output cases from classpath JSON fixtures.
 */
class ThreeSumTest : FreeSpec({

    val list = getInput()
    var expected = getExpected()
    expected = expected
            .asSequence()
            .map { it ->
                it
                        .map { it -> it.toInt() }
            }
            .toList()
    val inputs = mapOf(
            intArrayOf(-1, 0, 1, 2, -1, -4) to
                    listOf(
                            listOf(-1, 0, 1),
                            listOf(-1, -1, 2)
                    ),
            list to expected,
            intArrayOf(1, 2, -2, -1) to
                    emptyList(),
            intArrayOf(0, 0, 0) to
                    listOf(
                            listOf(0, 0, 0)
                    ),
            intArrayOf(0, 0, 0, 0, 0, 1, -1) to
                    listOf(
                            listOf(0, 0, 0),
                            listOf(-1, 0, 1)
                    ),
            intArrayOf(0, 0, 0, 0, 0) to
                    listOf(
                            listOf(0, 0, 0)
                    ),
            intArrayOf(-1, 0, 1) to
                    listOf(
                            listOf(-1, 0, 1)
                    )
    )

    "threeSumNaive" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.asString()} expected: ${expected.asString()}" {
                val actual = ThreeSumLegacy().threeSumNaive(input)
                println("actual.size: ${actual.size}")
                println("expected.size: ${expected.size}")
                actual shouldContainAll expected
            }
        }
    }

    "threeSum" - {
        inputs.asSequence().forEach { (input, expected) ->
            "input: ${input.asString()} expected: ${expected.asString()}" {
                val actual = ThreeSumLegacy().threeSum(input)
                println("actual.size: ${actual.size}")
                println("expected.size: ${expected.size}")
                actual shouldContainAll expected
                /*ThreeSumLegacy().threeSum(input).asSequence().forEach {
                    println("[${it[0]}, ${it[1]}, ${it[2]}], ")
                }*/
            }
        }
    }
})

private fun readFixture(name: String): String =
    requireNotNull(ThreeSumTest::class.java.getResource("/problems/p0015/$name")) {
        "Missing fixture: $name"
    }.readText()

private fun getInput(): IntArray {
    val name = "input.json"
    val s = readFixture(name)
    val gson = Gson()
    return gson.fromJson<List<Int>>(s, List::class.java).toIntArray()
}

private fun getExpected(): List<List<Int>> {
    val name = "expected.json"
    val s = readFixture(name)
    val gson = Gson()
    return gson.fromJson<List<List<Int>>>(s, List::class.java)
}
