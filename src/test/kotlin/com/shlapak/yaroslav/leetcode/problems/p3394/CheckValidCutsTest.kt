package com.shlapak.yaroslav.leetcode.problems.p3394

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

/**
 * Tests [CheckValidCuts.Intervals] and [CheckValidCuts.InPlace].
 *
 * Covers cuts on either axis, touching edges, overlapping projections, and input mutation.
 */
class CheckValidCutsTest : FreeSpec({
    val implementations: Map<String, (Int, Array<IntArray>) -> Boolean> = mapOf(
        "interval projections" to CheckValidCuts.Intervals()::checkValidCuts,
        "in-place sorting" to CheckValidCuts.InPlace()::checkValidCuts,
    )

    for ((name, check) in implementations) {
        name - {
            "finds horizontal cuts in unsorted rectangles" {
                check(5, arrayOf(
                    intArrayOf(0, 4, 3, 5),
                    intArrayOf(0, 0, 3, 1),
                    intArrayOf(0, 2, 3, 3),
                )) shouldBe true
            }

            "allows vertical cuts along touching rectangle edges" {
                check(3, arrayOf(
                    intArrayOf(2, 0, 3, 3),
                    intArrayOf(0, 0, 1, 3),
                    intArrayOf(1, 0, 2, 3),
                )) shouldBe true
            }

            "allows horizontal cuts along touching rectangle edges" {
                check(3, arrayOf(
                    intArrayOf(0, 2, 3, 3),
                    intArrayOf(0, 0, 3, 1),
                    intArrayOf(0, 1, 3, 2),
                )) shouldBe true
            }

            "rejects overlapping chains with only two groups on the other axis" {
                check(4, arrayOf(
                    intArrayOf(0, 0, 2, 1),
                    intArrayOf(1, 1, 3, 2),
                    intArrayOf(2, 0, 4, 1),
                )) shouldBe false
            }

            "retains the furthest end when one projection contains another" {
                check(6, arrayOf(
                    intArrayOf(0, 0, 6, 1),
                    intArrayOf(1, 1, 2, 3),
                    intArrayOf(3, 1, 4, 3),
                )) shouldBe false
            }

            "accepts more than three groups" {
                check(4, Array(4) { x -> intArrayOf(x, 0, x + 1, 4) }) shouldBe true
            }

            "rejects fewer than three rectangles" {
                check(3, emptyArray()) shouldBe false
                check(3, arrayOf(intArrayOf(0, 0, 1, 1))) shouldBe false
                check(3, arrayOf(
                    intArrayOf(0, 0, 1, 1),
                    intArrayOf(2, 2, 3, 3),
                )) shouldBe false
            }
        }
    }

    "interval projections preserve input order and coordinates" {
        val rectangles = arrayOf(
            intArrayOf(2, 0, 3, 3),
            intArrayOf(0, 0, 1, 3),
            intArrayOf(1, 0, 2, 3),
        )
        val originalOrder = rectangles.copyOf()
        val originalCoordinates = rectangles.map { it.toList() }

        CheckValidCuts.Intervals().checkValidCuts(3, rectangles) shouldBe true

        rectangles.indices.all { rectangles[it] === originalOrder[it] } shouldBe true
        rectangles.map { it.toList() } shouldBe originalCoordinates
    }

    "in-place sorting reorders references without changing coordinates" {
        val rectangles = arrayOf(
            intArrayOf(2, 0, 3, 3),
            intArrayOf(0, 0, 1, 3),
            intArrayOf(1, 0, 2, 3),
        )
        val originalOrder = rectangles.copyOf()
        val originalCoordinates = originalOrder.map { it.toList() }

        CheckValidCuts.InPlace().checkValidCuts(3, rectangles) shouldBe true

        rectangles.map { it[0] } shouldBe listOf(0, 1, 2)
        originalOrder.map { it.toList() } shouldBe originalCoordinates
        rectangles.all { rectangle -> originalOrder.any { it === rectangle } } shouldBe true
    }
})
