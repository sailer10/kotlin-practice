package com.example.kotlinpractice.exercises.generics

import com.example.kotlinpractice.exercises.generics.Generics as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class GenericsTest {
    @Test
    @DisplayName("variance - 선언 지점 out/in 공변·반공변")
    fun variance() {
        assertEquals("Kotlin", Subject.variance())
    }

    @Test
    @DisplayName("projections - 사용 지점 out과 star projection")
    fun projections() {
        assertEquals(listOf(2, 7), Subject.projections())
    }

    @Test
    @DisplayName("reified - inline reified 타입 검사")
    fun reified() {
        assertEquals(listOf("a", "b"), Subject.reified())
    }

    @Test
    @DisplayName("bounds - where 다중 상한")
    fun bounds() {
        assertEquals("Kotlin", Subject.bounds())
    }

    @Test
    @DisplayName("definitelyNonNull - T & Any 확실한 비-null 타입")
    fun definitelyNonNull() {
        assertEquals("Kotlin", Subject.definitelyNonNull())
    }

    @Test
    @DisplayName("underscore - 타입 인자 _ 추론")
    fun underscore() {
        assertEquals("a" to 2, Subject.underscore())
    }
}
