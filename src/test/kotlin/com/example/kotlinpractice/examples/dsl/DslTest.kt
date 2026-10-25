package com.example.kotlinpractice.examples.dsl

import com.example.kotlinpractice.examples.dsl.Dsl as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DslTest {
    @Test
    @DisplayName("build - @DslMarker, 수신 객체 람다, 타입 안전 builder")
    fun build() {
        assertEquals(listOf("Variables", "Functions"), Subject.build())
    }

    @Test
    @DisplayName("multiDollar - multi-dollar 문자열 보간")
    fun multiDollar() {
        assertEquals("{\"price\":\"$5\",\"language\":\"Kotlin\"}", Subject.multiDollar())
    }

    @Test
    @DisplayName("expressionReturn - 명시적 반환 타입 표현식 본문에서 return")
    fun expressionReturn() {
        assertEquals("unknown", Subject.expressionReturn(null))
        assertEquals("ok", Subject.expressionReturn("ok"))
    }
}
