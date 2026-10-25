package com.example.kotlinpractice.examples.generics

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
        val wide: Producer<Any> = Producer("Kotlin")
        var result = ""
        val anyConsumer: Consumer<Any> = Consumer { result = it.toString() }
        val textConsumer: Consumer<String> = anyConsumer
        textConsumer.accept(wide.get().toString())
        return result
    }

    /** 사용 지점 out과 star projection. */
    fun projections(): List<Int> {
        val count = size(listOf("a", 2))
        val first = copyFirst(arrayOf(7, 8))
        return listOf(count, first.toInt())
    }

    /** inline reified 타입 검사. */
    fun reified(): List<String> {
        return select<String>(listOf("a", 1, "b"))
    }

    /** where 다중 상한. */
    fun bounds(): String {
        return bounded("Kotlin")
    }

    /** T & Any 확실한 비-null 타입. */
    fun definitelyNonNull(): String {
        return nonNull<String?>("Kotlin")
    }

    /** 타입 인자 _ 추론. */
    fun underscore(): Pair<String, Int> {
        fun <A, B> pair(a: A, b: B): Pair<A, B> = a to b
        return pair<String, _>("a", 2)
    }
}
