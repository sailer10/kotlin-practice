package com.example.kotlinpractice.exercises.modeling

import com.example.kotlinpractice.exercises.modeling.Modeling as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class ModelingTest {
    @Test
    @DisplayName("data - data class, copy, 구조 분해, 값 동등성")
    fun data() {
        assertEquals("Seil:2:false", Subject.data())
    }

    @Test
    @DisplayName("enums - enum class, entries, valueOf, ordinal")
    fun enums() {
        assertEquals(listOf(0, 1, 1), Subject.enums())
    }

    @Test
    @DisplayName("sealed - sealed interface, data object, exhaustive when")
    fun sealed() {
        assertEquals(0, Subject.sealed(true))
        assertEquals(3, Subject.sealed(false))
    }

    @Test
    @DisplayName("valueClass - value class와 @JvmInline")
    fun valueClass() {
        assertEquals(42L, Subject.valueClass(42))
    }

    @Test
    @DisplayName("sam - fun interface와 SAM 변환")
    fun sam() {
        assertEquals("KOTLIN", Subject.sam())
    }

    @Test
    @DisplayName("aliases - 최상위·중첩 typealias")
    fun aliases() {
        assertEquals(1, Subject.aliases())
    }

    @Test
    @DisplayName("equality - ==, ===, !==")
    fun equality() {
        assertEquals(listOf(true, false, true), Subject.equality())
    }
}
