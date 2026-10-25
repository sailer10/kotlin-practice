package com.example.kotlinpractice.examples.functions

import com.example.kotlinpractice.examples.functions.Functions as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FunctionsTest {
    @Test
    @DisplayName("arguments - 기본 인자, 이름 있는 인자, 단일 표현식 함수")
    fun arguments() {
        assertEquals(listOf("Hello, world", "Hi, Seil"), Subject.arguments())
    }

    @Test
    @DisplayName("varargs - vararg, spread 연산자")
    fun varargs() {
        assertEquals(6, Subject.varargs(intArrayOf(2, 3)))
        assertEquals(1, Subject.varargs(intArrayOf()))
    }

    @Test
    @DisplayName("extensions - 확장 함수와 확장 프로퍼티")
    fun extensions() {
        assertEquals("K:kotlin kotlin ", Subject.extensions("kotlin "))
    }

    @Test
    @DisplayName("infix - infix 함수")
    fun infix() {
        assertEquals("hahaha", Subject.infix())
    }

    @Test
    @DisplayName("local - 지역 함수")
    fun local() {
        assertEquals(16, Subject.local(4))
    }

    @Test
    @DisplayName("tailRecursion - tailrec와 require")
    fun tailRecursion() {
        assertEquals(120L, Subject.tailRecursion(5))
        assertEquals(1L, Subject.tailRecursion(0))
        assertFailsWith<IllegalArgumentException> { Subject.tailRecursion(-1) }
    }
}
