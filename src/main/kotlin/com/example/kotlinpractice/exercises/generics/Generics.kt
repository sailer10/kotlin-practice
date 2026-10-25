package com.example.kotlinpractice.exercises.generics

private class Producer<out T>(private val value: T) {
    fun get(): T = value
}

private fun interface Consumer<in T> {
    fun accept(value: T)
}

private fun copyFirst(source: Array<out Number>): Number = source.first()

private fun size(values: List<*>): Int = values.size

private inline fun <reified T> select(values: List<Any>): List<T> = values.filterIsInstance<T>()

private fun <T> bounded(value: T): String where T : CharSequence, T : Comparable<T> =
    value.toString()

private fun <T> nonNull(value: T & Any): T & Any = value

/** 공식 문서: https://kotlinlang.org/docs/generics.html */
object Generics {
    /** 선언 지점 out/in 공변·반공변. */
    fun variance(): String {
        TODO("선언 지점 out/in 공변·반공변")
    }

    /** 사용 지점 out과 star projection. */
    fun projections(): List<Int> {
        TODO("사용 지점 out과 star projection")
    }

    /** inline reified 타입 검사. */
    fun reified(): List<String> {
        TODO("inline reified 타입 검사")
    }

    /** where 다중 상한. */
    fun bounds(): String {
        TODO("where 다중 상한")
    }

    /** T & Any 확실한 비-null 타입. */
    fun definitelyNonNull(): String {
        TODO("T & Any 확실한 비-null 타입")
    }

    /** 타입 인자 _ 추론. */
    fun underscore(): Pair<String, Int> {
        TODO("타입 인자 _ 추론")
    }
}
