package com.example.kotlinpractice.exercises.scopeandexceptions

import com.example.kotlinpractice.exercises.scopeandexceptions.ScopeAndExceptions as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class ScopeAndExceptionsTest {
    @Test
    @DisplayName("scope - let, run, with, apply, also")
    fun scope() {
        assertEquals("3:2", Subject.scope())
    }

    @Test
    @DisplayName("take - takeIf와 takeUnless")
    fun take() {
        assertEquals(2, Subject.take(2))
        assertNull(Subject.take(-1))
        assertNull(Subject.take(3))
    }

    @Test
    @DisplayName("exception - try 표현식, catch, finally")
    fun exception() {
        assertEquals(42, Subject.exception("42"))
        assertEquals(-1, Subject.exception("bad"))
    }

    @Test
    @DisplayName("result - Result와 runCatching")
    fun result() {
        assertEquals(42, Subject.result("42"))
        assertEquals(0, Subject.result("bad"))
    }

    @Test
    @DisplayName("resources - use와 자원 해제")
    fun resources() {
        assertEquals("Kotlin", Subject.resources())
    }
}
