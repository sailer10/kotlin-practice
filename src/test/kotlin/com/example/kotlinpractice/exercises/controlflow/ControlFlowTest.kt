package com.example.kotlinpractice.exercises.controlflow

import com.example.kotlinpractice.exercises.controlflow.ControlFlow as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class ControlFlowTest {
    @Test
    @DisplayName("max - if 표현식")
    fun max() {
        assertEquals(8, Subject.max(3, 8))
        assertEquals(3, Subject.max(3, -1))
    }

    @Test
    @DisplayName("classify - when, is, 스마트 캐스트, guard 조건")
    fun classify() {
        assertEquals("positive", Subject.classify(2))
        assertEquals("other integer", Subject.classify(-1))
        assertEquals("text", Subject.classify("a"))
        assertEquals("null", Subject.classify(null))
        assertEquals("other", Subject.classify(true))
    }

    @Test
    @DisplayName("ranges - ..<, step, downTo")
    fun ranges() {
        assertEquals(listOf(1, 3, 5, 4, 3, 2), Subject.ranges())
    }

    @Test
    @DisplayName("loops - for, while, do while, break, continue")
    fun loops() {
        assertEquals(11, Subject.loops(10))
        assertEquals(3, Subject.loops(0))
    }

    @Test
    @DisplayName("labels - 라벨과 return@forEach")
    fun labels() {
        assertEquals(listOf(11, 13, 1, 3), Subject.labels())
    }

    @Test
    @DisplayName("nonLocalJump - inline 람다에서 비지역 break와 continue")
    fun nonLocalJump() {
        assertEquals(4, Subject.nonLocalJump())
    }
}
