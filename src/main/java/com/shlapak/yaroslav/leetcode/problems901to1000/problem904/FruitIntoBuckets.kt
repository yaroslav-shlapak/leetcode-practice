package com.shlapak.yaroslav.leetcode.problems901to1000.problem904

class FruitIntoBuckets {
    fun totalFruit(fruits: IntArray): Int {
        var max = 0
        var i = 0
        val basket = IntArray(2)
        val empty = -1
        while (i < fruits.size) {
            basket[0] = fruits[i]
            basket[1] = empty
            var j = i
            var lastPickedIndex = i

            // iterate until the basket cannot be filled
            while (j < fruits.size &&
                (basket[0] == fruits[j] || basket[1] == fruits[j] || basket[1] == empty)
            ) {
                // init the second basket
                if (basket[0] != fruits[j] && basket[1] == empty) {
                    basket[1] = fruits[j]
                }
                // save the last picked index
                if (fruits[lastPickedIndex] != fruits[j]) {
                    lastPickedIndex = j
                }
                j++
            }
            max = maxOf(max, j - i)
            // break loop at the end
            if (i == lastPickedIndex) {
                break
            }
            i = lastPickedIndex
        }
        return max
    }

    fun totalFruit2(fruits: IntArray): Int {
        var maxFruits = 0
        var left = 0
        val basket = LinkedHashMap<Int, Int>()

        for (right in fruits.indices) {
            val fruit = fruits[right]
            basket[fruit] = right

            if (basket.size > 2) {
                val minIndex = basket.values.min()
                basket.remove(fruits[minIndex])
                left = minIndex + 1
            }

            maxFruits = maxOf(maxFruits, right - left + 1)
        }

        return maxFruits
    }

    fun totalFruit3(fruits: IntArray): Int {
        var maxFruits = 0
        var left = 0
        val fruitCounts = mutableMapOf<Int, Int>() // Fruit type -> Count in window

        for (right in fruits.indices) {
            val fruitRight = fruits[right]
            // Add the current fruit to the window
            fruitCounts[fruitRight] = fruitCounts.getOrDefault(fruitRight, 0) + 1

            // Shrink the window if more than 2 types of fruit are present
            while (fruitCounts.size > 2) {
                val fruitLeft = fruits[left]
                fruitCounts[fruitLeft] = fruitCounts[fruitLeft]!! - 1 // Decrement count
                if (fruitCounts[fruitLeft] == 0) {
                    fruitCounts.remove(fruitLeft) // Remove if count is zero
                }
                left++ // Move the left boundary of the window
            }

            // Update the maximum number of fruits collected
            // Current window size is right - left + 1
            maxFruits = maxOf(maxFruits, right - left + 1)
        }

        return maxFruits
    }

    fun totalFruit4(fruits: IntArray): Int {

        var left: Int = 0
        var right: Int = left
        var index: Int = -1
        var lastMax: Int = 0

        while (right < fruits.size) {
            right = left
            while (right < fruits.size && fruits[left] == fruits[right]) {
                right++
            }
            if (right < fruits.size) {
                index = right
            }
            while (right < fruits.size && (fruits[right] == fruits[left] || fruits[right] == fruits[index])) {
                right++
            }
            lastMax = maxOf(lastMax, right - left)
            left = index
        }

        return lastMax

    }


    buffered
}