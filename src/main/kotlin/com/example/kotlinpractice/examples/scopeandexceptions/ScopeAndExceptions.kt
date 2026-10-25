package com.example.kotlinpractice.examples.scopeandexceptions

import java.io.StringReader

/** 공식 문서: https://kotlinlang.org/docs/scope-functions.html */
object ScopeAndExceptions {
    /** let, run, with, apply, also. */
    fun scope(): String {
        val values = mutableListOf<Int>().apply { add(1) }.also { it.add(2) }
        val sum = values.let { it.sum() }
        val size = with(values) { size }
        return run { "$sum:$size" }
    }

    /** takeIf와 takeUnless. */
    fun take(value: Int): Int? {
        return value.takeIf { it > 0 }?.takeUnless { it == 3 }
    }

    /** try 표현식, catch, finally. */
    fun exception(text: String): Int {
        return try {
            text.toInt()
        } catch (_: NumberFormatException) {
            -1
        } finally {
            check(text.length >= 0)
        }
    }

    /** Result와 runCatching. */
    fun result(text: String): Int {
        return runCatching { text.toInt() }.getOrElse { 0 }
    }

    /** use와 자원 해제. */
    fun resources(): String {
        return StringReader("Kotlin").use { it.readText() }
    }
}
