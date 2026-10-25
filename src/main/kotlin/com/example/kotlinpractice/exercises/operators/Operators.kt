package com.example.kotlinpractice.exercises.operators

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
        TODO("plus, minus, unaryMinus, inc, componentN")
    }

    /** get/set, invoke, contains, iterator. */
    fun indexed(): List<Int> {
        TODO("get/set, invoke, contains, iterator")
    }

    /** compareTo 비교 관례. */
    fun comparison(): Boolean {
        TODO("compareTo 비교 관례")
    }
}
