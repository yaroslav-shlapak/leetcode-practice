package com.shlapak.yaroslav.leetcode.utils

/**
 * Created on 2019/04/24.
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