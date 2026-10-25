package com.example.kotlinpractice.examples.controlflow

/** 공식 문서: https://kotlinlang.org/docs/control-flow.html */
object ControlFlow {
    /** if 표현식. */
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    /** when, is, 스마트 캐스트, guard 조건. */
    fun classify(value: Any?): String {
        return when (value) {
            null -> "null"
            is Int if value > 0 -> "positive"
            is Int -> "other integer"
            is String -> "text"
            else -> "other"
        }
    }

    /** ..<, step, downTo. */
    fun ranges(): List<Int> {
        return (1..<7 step 2).toList() + (4 downTo 2).toList()
    }

    /** for, while, do while, break, continue. */
    fun loops(limit: Int): Int {
        var sum = 0
        for (n in 0..limit) {
            if (n == 2) continue
            if (n > 4) break
            sum += n
        }
        var counter = 0
        while (counter < 2) {
            sum++
            counter++
        }
        do {
            sum++
        } while (false)
        return sum
    }

    /** 라벨과 return@forEach. */
    fun labels(): List<Int> {
        val result = mutableListOf<Int>()
        outer@ for (a in 1..3) {
            for (b in 1..3) {
                if (a == 2) break@outer
                if (b == 2) continue
                result += a * 10 + b
            }
        }
        listOf(1, 2, 3).forEach {
            if (it == 2) return@forEach
            result += it
        }
        return result
    }

    /** inline 람다에서 비지역 break와 continue. */
    fun nonLocalJump(): Int {
        var result = 0
        for (n in 1..5) {
            run {
                if (n == 2) continue
                if (n == 4) break
            }
            result += n
        }
        return result
    }
}
