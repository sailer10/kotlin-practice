package com.example.kotlinpractice.exercises.functional

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
        TODO("함수 타입, 고차 함수, trailing lambda, it")
    }

    /** 클로저와 캡처 변수. */
    fun closure(): List<Int> {
        TODO("클로저와 캡처 변수")
    }

    /** 함수 참조와 프로퍼티 참조. */
    fun references(): List<Int> {
        TODO("함수 참조와 프로퍼티 참조")
    }

    /** 익명 함수의 지역 return. */
    fun anonymous(): Int {
        TODO("익명 함수의 지역 return")
    }

    /** 수신 객체가 있는 함수 타입. */
    fun receiver(): String {
        TODO("수신 객체가 있는 함수 타입")
    }

    /** inline과 비지역 return. */
    fun inlineReturn(): Int {
        TODO("inline과 비지역 return")
    }

    /** noinline과 crossinline. */
    fun inlineModifiers(): Int {
        TODO("noinline과 crossinline")
    }
}
