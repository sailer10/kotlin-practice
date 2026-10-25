package com.example.kotlinpractice.examples.operators

private data class Point(val x: Int, val y: Int) : Comparable<Point> {
    operator fun plus(other: Point) = Point(x + other.x, y + other.y)

    operator fun minus(other: Point) = Point(x - other.x, y - other.y)

    operator fun unaryMinus() = Point(-x, -y)

    operator fun inc() = Point(x + 1, y + 1)

    override operator fun compareTo(other: Point) = (x + y).compareTo(other.x + other.y)
}

private class Bag(private val values: MutableList<Int>) : Iterable<Int> {
    operator fun get(index: Int) = values[index]

    operator fun set(index: Int, value: Int) {
        values[index] = value
    }

    operator fun contains(value: Int) = value in values

    operator fun invoke() = values.sum()

    override operator fun iterator() = values.iterator()
}

/** 공식 문서: https://kotlinlang.org/docs/operator-overloading.html */
object Operators {
    /** plus, minus, unaryMinus, inc, componentN. */
    fun arithmetic(): List<Int> {
        val point = Point(1, 2) + Point(3, 4) - Point(1, 1)
        val negative = -point
        var next = point
        next++
        val (x, y) = next
        return listOf(negative.x, negative.y, x, y)
    }

    /** get/set, invoke, contains, iterator. */
    fun indexed(): List<Int> {
        val bag = Bag(mutableListOf(1, 2))
        bag[0] = 5
        return listOf(bag[0], bag(), if (2 in bag) 1 else 0, bag.sum())
    }

    /** compareTo 비교 관례. */
    fun comparison(): Boolean {
        return Point(1, 1) < Point(2, 2)
    }
}
