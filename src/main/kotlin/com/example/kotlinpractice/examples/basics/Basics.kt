package com.example.kotlinpractice.examples.basics

private const val BONUS = 2

/** 공식 문서: https://kotlinlang.org/docs/basic-syntax.html */
object Basics {
    /** val, var, const, 타입 추론과 복합 대입. */
    fun variables(start: Int): Int {
        val initial: Int = start
        var total = initial
        total += BONUS
        return total
    }

    /** 정수·실수·unsigned 리터럴과 명시적 변환. */
    fun numbers(): List<Long> {
        val hex = 0xFF
        val binary = 0b1010
        val grouped = 1_000L
        val small: Byte = 2
        val fraction: Float = 2.5f
        val unsigned: UInt = 3u
        return listOf(
            hex.toLong(),
            binary.toLong(),
            grouped,
            small.toLong(),
            fraction.toLong(),
            unsigned.toLong(),
        )
    }

    /** Char, 이스케이프, 문자열 템플릿. */
    fun strings(name: String): String {
        val letter: Char = 'K'
        return "$letter: ${name.uppercase()}\n${name.length}"
    }

    /** 여러 줄 문자열과 trimMargin. */
    fun rawString(): String {
        return """
        |first
        |second
        """
            .trimMargin()
    }

    /** 배열과 원시 타입 배열. */
    fun arrays(): List<Int> {
        val boxed = arrayOf(1, 2)
        val primitive = intArrayOf(3, 4)
        boxed[0] = 5
        return boxed.toList() + primitive.toList()
    }

    /** 비트 연산 shl, or, and. */
    fun bits(value: Int): Int {
        return ((value shl 1) or 1) and 15
    }
}
