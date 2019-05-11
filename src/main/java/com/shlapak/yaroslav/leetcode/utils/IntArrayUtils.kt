package com.shlapak.yaroslav.leetcode.utils

/**
 * Created on 2019/04/24.
 */
fun IntArray.getSting(): String {
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

fun List<List<Int>>.getSting(): String {
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