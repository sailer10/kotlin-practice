package com.example.kotlinpractice.exercises.functions

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
        TODO("기본 인자, 이름 있는 인자, 단일 표현식 함수")
    }

    /** vararg, spread 연산자. */
    fun varargs(values: IntArray): Int {
        TODO("vararg, spread 연산자")
    }

    /** 확장 함수와 확장 프로퍼티. */
    fun extensions(text: String): String {
        TODO("확장 함수와 확장 프로퍼티")
    }

    /** infix 함수. */
    fun infix(): String {
        TODO("infix 함수")
    }

    /** 지역 함수. */
    fun local(value: Int): Int {
        TODO("지역 함수")
    }

    /** tailrec와 require. */
    fun tailRecursion(n: Int): Long {
        TODO("tailrec와 require")
    }
}
