package com.example.kotlinpractice.examples.functional

private fun firstPositive(values: List<Int>): Int {
    values.forEach { if (it > 0) return it }
    return -1
}

private inline fun invokeBoth(noinline first: () -> Int, crossinline second: () -> Int): Int {
    val saved = first
    var result = 0
    val action = Runnable { result = second() }
    action.run()
    return saved() + result
}

private fun kotlinAbsolute(value: Int) = if (value < 0) -value else value

/** 공식 문서: https://kotlinlang.org/docs/lambdas.html */
object Functional {
    /** 함수 타입, 고차 함수, trailing lambda, it. */
    fun transform(values: List<Int>, operation: (Int) -> Int): List<Int> {
        return values.map(operation)
    }

    /** 클로저와 캡처 변수. */
    fun closure(): List<Int> {
        var count = 0
        val next = { ++count }
        return listOf(next(), next(), next())
    }

    /** 함수 참조와 프로퍼티 참조. */
    fun references(): List<Int> {
        val size: (String) -> Int = String::length
        val absolute: (Int) -> Int = ::kotlinAbsolute
        return listOf(size("abc"), absolute(-4))
    }

    /** 익명 함수의 지역 return. */
    fun anonymous(): Int {
        val double =
            fun(value: Int): Int {
                return value * 2
            }
        return double(4)
    }

    /** 수신 객체가 있는 함수 타입. */
    fun receiver(): String {
        val block: StringBuilder.() -> Unit = {
            append("Kotlin")
            append("!")
        }
        return buildString(block)
    }

    /** inline과 비지역 return. */
    fun inlineReturn(): Int {
        return firstPositive(listOf(-1, 0, 3, 4))
    }

    /** noinline과 crossinline. */
    fun inlineModifiers(): Int {
        return invokeBoth({ 2 }, { 3 })
    }
}
