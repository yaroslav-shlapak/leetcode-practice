package com.shlapak.yaroslav.leetcode.problem15

import com.google.gson.Gson
import com.shlapak.yaroslav.leetcode.problem15.SolutionTest.getExpected
import com.shlapak.yaroslav.leetcode.problem15.SolutionTest.getInput
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
            .map { it -> it
                    .map { it -> it.toInt() }}
            .toList()
    val inputs = mapOf(
            intArrayOf(-1, 0, 1, 2, -1, -4) to
                    listOf(
                            listOf(-1, 0, 1),
                            listOf(-1, -1, 2)
                    ),
            list to expected
    )

    group("threeSumNaive") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.slice(0..2)} expected: ${expected.subList(0, 2)}") {
                Solution().threeSumNaive(input) shouldContainAll expected
            }
        }
    }

    group("threeSum") {
        inputs.asSequence().forEach { (input, expected) ->
            test("input: ${input.slice(0..2)} expected: ${expected.subList(0, 2)}") {
                Solution().threeSum(input) shouldContainAll  expected
                /*Solution().threeSum(input).asSequence().forEach {
                    println("[${it[0]}, ${it[1]}, ${it[2]}], ")
                }*/
            }
        }
    }
}) {
    val path = Paths.get("").toAbsolutePath().toString() +
            "/src/test/java/com/shlapak/yaroslav/leetcode/problem15/"

    fun getInput(): IntArray  {
        val name = "input.json"
        val inputFilePath = path + name
        val file = File(inputFilePath)
        val s = file.readText()
        val gson = Gson()
        return gson.fromJson<List<Int>>(s, List::class.java).toIntArray()
    }

    fun getExpected(): List<List<Int>>  {
        val name = "expected.json"
        val inputFilePath = path + name
        val file = File(inputFilePath)
        val s = file.readText()
        val gson = Gson()
        return gson.fromJson<List<List<Int>>>(s, List::class.java)
    }
}
