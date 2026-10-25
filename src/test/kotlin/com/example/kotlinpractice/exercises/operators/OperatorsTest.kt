package com.example.kotlinpractice.exercises.operators

import com.example.kotlinpractice.exercises.operators.Operators as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class OperatorsTest {
    @Test
    @DisplayName("arithmetic - plus, minus, unaryMinus, inc, componentN")
    fun arithmetic() {
        assertEquals(listOf(-3, -5, 4, 6), Subject.arithmetic())
    }

    @Test
    @DisplayName("indexed - get/set, invoke, contains, iterator")
    fun indexed() {
        assertEquals(listOf(5, 7, 1, 7), Subject.indexed())
    }

    @Test
    @DisplayName("comparison - compareTo 비교 관례")
    fun comparison() {
        assertTrue(Subject.comparison())
    }
}
