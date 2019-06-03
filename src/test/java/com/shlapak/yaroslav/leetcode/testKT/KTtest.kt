package com.shlapak.yaroslav.leetcode.testKT

import io.kotlintest.specs.FreeSpec
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created on 2019/06/03.
 */
class MyTests : FreeSpec({
    val globalFixture = initGlobalFixture()
    "a test group 0" - {
        val group0Fixture = intitGroup0Fixture()
        "test 0" {
            test0Fixture()
            test0Exercise()
            test0Assertion()
        }
        "test 1" {
            tes1Fixture()
            test1Exercise()
            test1Assertion()
        }
    }
    "a test group 1" - {
        val group1Fixture = initGroup1Fixture()
        "a test group 2" - {
            val group2Fixture = initGroup2Fixture()
            "test 0" {
                test0Fixture()
                test0Exercise()
                test0Assertion()
            }
            "test 1" {
                tes1Fixture()
                test1Exercise()
                test1Assertion()
            }
        }
        "a test group 3" - {
            val group3Fixture = initGroup3Fixture()
            "test 0" {
                test0Fixture()
                test0Exercise()
                test0Assertion()
            }
            "test 1" {
                tes1Fixture()
                test1Exercise()
                test1Assertion()
            }
        }
    }
    "a test group 4" - {
        val group4Fixture = (0..100).toList()
        group4Fixture.forEach {
            "test $it" {
                test0Fixture()
                test0Exercise()
                test0Assertion()
            }
        }
    }

})


val group1Counter = AtomicInteger(0)
val group2Counter = AtomicInteger(0)
val group3Counter = AtomicInteger(0)
val globalFixtureCounter = AtomicInteger(0)
fun initGroup1Fixture(): Any {
    println("group1counter: ${group1Counter.getAndIncrement()}")
    return Any()
}

fun initGroup2Fixture(): Any {
    println("group2Counter: ${group2Counter.getAndIncrement()}")
    return Any()
}

fun initGroup3Fixture(): Any {
    println("group3Counter: ${group3Counter.getAndIncrement()}")
    return Any()
}

fun initGroup4Fixture(): Any {
    println("group2Counter: ${group2Counter.getAndIncrement()}")
    return Any()
}

fun test1Assertion() {
    println("globalFixtureCounter: ${globalFixtureCounter}")
}

fun test1Exercise() {
    globalFixtureCounter.getAndIncrement()
}

fun tes1Fixture() {

}

fun test0Assertion() {
    println("globalFixtureCounter: ${globalFixtureCounter}")
}

fun test0Exercise() {
    globalFixtureCounter.getAndIncrement()
}

fun test0Fixture() {

}

fun intitGroup0Fixture(): Any {
    return Any()
}

fun initGlobalFixture(): Any {
    println("globalFixtureCounter: ${globalFixtureCounter.getAndIncrement()}")
    return Any()
}
