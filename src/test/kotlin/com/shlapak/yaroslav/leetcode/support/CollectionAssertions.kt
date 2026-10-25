package com.shlapak.yaroslav.leetcode.support

import kotlin.test.assertEquals

/**
 * Compares complete unordered results, including the number of occurrences of each element.
 *
 * Uses standard equality and hash codes so large fixtures can be compared without quadratic
 * pairwise matching. Normalize nested collections first when their internal order is irrelevant.
 */
fun <T> Collection<T>.shouldMatchUnordered(expected: Collection<T>) {
    assertEquals(expected.groupingBy { it }.eachCount(), groupingBy { it }.eachCount())
}
