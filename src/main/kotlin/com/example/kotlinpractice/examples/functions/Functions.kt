package com.example.kotlinpractice.examples.functions

private fun greet(name: String = "world", prefix: String = "Hello") = "$prefix, $name"

private fun sum(vararg values: Int) = values.sum()

private fun String.initial() = first().uppercaseChar()

private val String.twice: String
    get() = this + this

private infix fun Int.timesText(text: String) = text.repeat(this)

private tailrec fun factorial(n: Int, acc: Long = 1): Long =
    if (n <= 1) acc else factorial(n - 1, n * acc)

/** 공식 문서: https://kotlinlang.org/docs/functions.html */
object Functions {
    /** 기본 인자, 이름 있는 인자, 단일 표현식 함수. */
    fun arguments(): List<String> {
        return listOf(greet(), greet(prefix = "Hi", name = "Seil"))
    }

    /** vararg, spread 연산자. */
    fun varargs(values: IntArray): Int {
        return sum(1, *values)
    }

    /** 확장 함수와 확장 프로퍼티. */
    fun extensions(text: String): String {
        return "${text.initial()}:${text.twice}"
    }

    /** infix 함수. */
    fun infix(): String {
        return 3 timesText "ha"
    }

    /** 지역 함수. */
    fun local(value: Int): Int {
        fun square(n: Int): Int = n * n
        return square(value)
    }

    /** tailrec와 require. */
    fun tailRecursion(n: Int): Long {
        require(n >= 0)
        return factorial(n)
    }
}
