package com.shlapak.yaroslav.leetcode.support

/**
 * Formats at most the first five array values for test diagnostics.
 *
 * An empty array uses its default object representation.
 */
fun IntArray.asString(): String {
    return when (val size = this.size) {
        0 -> {
            this.toString()
        }
        in 0..5 -> {
            this.slice(0 until size).toString()
        }
        else -> {
            this.slice(0 until 5).toString()
        }
    }
}

/**
 * Formats at most the first five list elements for test diagnostics.
 */
fun <T> List<T>.asString(): String {
    return when (val size = this.size) {
        0 -> {
            this.toString()
        }
        in 0..5 -> {
            this.slice(0 until size).toString()
        }
        else -> {
            this.slice(0 until 5).toString()
        }
    }
}

/**
 * Formats at most the first five characters for test diagnostics.
 *
 * An empty string is returned unchanged.
 */
fun String.asString(): String {
    return when (val size = this.length) {
        0 -> {
            this
        }
        in 0..5 -> {
            this.slice(0 until size)
        }
        else -> {
            this.slice(0 until 5)
        }
    }
}
