package com.example.kotlinpractice.exercises.basics

import com.example.kotlinpractice.exercises.basics.Basics as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class BasicsTest {
    @Test
    @DisplayName("variables - val, var, const, 타입 추론과 복합 대입")
    fun variables() {
        assertEquals(7, Subject.variables(5))
    }

    @Test
    @DisplayName("numbers - 정수·실수·unsigned 리터럴과 명시적 변환")
    fun numbers() {
        assertEquals(listOf(255L, 10L, 1000L, 2L, 2L, 3L), Subject.numbers())
    }

    @Test
    @DisplayName("strings - Char, 이스케이프, 문자열 템플릿")
    fun strings() {
        assertEquals("K: KOTLIN\n6", Subject.strings("Kotlin"))
    }

    @Test
    @DisplayName("rawString - 여러 줄 문자열과 trimMargin")
    fun rawString() {
        assertEquals("first\nsecond", Subject.rawString())
    }

    @Test
    @DisplayName("arrays - 배열과 원시 타입 배열")
    fun arrays() {
        assertEquals(listOf(5, 2, 3, 4), Subject.arrays())
    }

    @Test
    @DisplayName("bits - 비트 연산 shl, or, and")
    fun bits() {
        assertEquals(7, Subject.bits(3))
    }
}
