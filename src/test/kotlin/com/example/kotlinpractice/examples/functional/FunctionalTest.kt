package com.example.kotlinpractice.examples.functional

import com.example.kotlinpractice.examples.functional.Functional as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FunctionalTest {
    @Test
    @DisplayName("transform - 함수 타입, 고차 함수, trailing lambda, it")
    fun transform() {
        assertEquals(listOf(2, 4), Subject.transform(listOf(1, 2)) { it * 2 })
        assertEquals(emptyList(), Subject.transform(emptyList()) { it })
    }

    @Test
    @DisplayName("closure - 클로저와 캡처 변수")
    fun closure() {
        assertEquals(listOf(1, 2, 3), Subject.closure())
    }

    @Test
    @DisplayName("references - 함수 참조와 프로퍼티 참조")
    fun references() {
        assertEquals(listOf(3, 4), Subject.references())
    }

    @Test
    @DisplayName("anonymous - 익명 함수의 지역 return")
    fun anonymous() {
        assertEquals(8, Subject.anonymous())
    }

    @Test
    @DisplayName("receiver - 수신 객체가 있는 함수 타입")
    fun receiver() {
        assertEquals("Kotlin!", Subject.receiver())
    }

    @Test
    @DisplayName("inlineReturn - inline과 비지역 return")
    fun inlineReturn() {
        assertEquals(3, Subject.inlineReturn())
    }

    @Test
    @DisplayName("inlineModifiers - noinline과 crossinline")
    fun inlineModifiers() {
        assertEquals(5, Subject.inlineModifiers())
    }
}
