package com.shlapak.yaroslav.leetcode.problem15

import com.google.gson.Gson
import com.shlapak.yaroslav.leetcode.problem15.SolutionTest.getExpected
import com.shlapak.yaroslav.leetcode.problem15.SolutionTest.getInput
import com.shlapak.yaroslav.leetcode.utils.getSting
import io.kotlintest.matchers.collections.shouldContainAll
import org.spekframework.spek2.Spek
import java.io.File
import java.nio.file.Paths

/**
 * Created on 2019/04/13.
 */
/** tests for
 * @see com.shlapak.yaroslav.leetcode.problem15.Solution
 **/
object SolutionTest : Spek({

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

    group("threeSumNaive") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.getSting()} expected: ${expected.getSting()}") {
                val actual = Solution().threeSumNaive(input)
                println("actual.size: ${actual.size}")
                println("expected.size: ${expected.size}")
                actual shouldContainAll expected
            }
        }
    }

    group("threeSum") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.getSting()} expected: ${expected.getSting()}") {
                val actual = Solution().threeSum(input)
                println("actual.size: ${actual.size}")
                println("expected.size: ${expected.size}")
                actual shouldContainAll expected
                /*Solution().threeSum(input).asSequence().forEach {
                    println("[${it[0]}, ${it[1]}, ${it[2]}], ")
                }*/
            }
        }
    }
}) {
    val path = Paths.get("").toAbsolutePath().toString() +
            "/src/test/java/com/shlapak/yaroslav/leetcode/problem15/"

    fun getInput(): IntArray {
        val name = "input.json"
        val inputFilePath = path + name
        val file = File(inputFilePath)
        val s = file.readText()
        val gson = Gson()
        return gson.fromJson<List<Int>>(s, List::class.java).toIntArray()
    }

    fun getExpected(): List<List<Int>> {
        val name = "expected.json"
        val inputFilePath = path + name
        val file = File(inputFilePath)
        val s = file.readText()
        val gson = Gson()
        return gson.fromJson<List<List<Int>>>(s, List::class.java)
    }
}