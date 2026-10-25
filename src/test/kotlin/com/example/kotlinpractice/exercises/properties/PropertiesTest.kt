package com.example.kotlinpractice.exercises.properties

import com.example.kotlinpractice.exercises.properties.Properties as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class PropertiesTest {
    @Test
    @DisplayName("accessors - 커스텀 접근자와 backing field")
    fun accessors() {
        assertEquals(listOf(0, 4), Subject.accessors())
    }

    @Test
    @DisplayName("lateinit - lateinit와 isInitialized")
    fun lateinit() {
        assertEquals(listOf(false, true), Subject.lateinit())
    }

    @Test
    @DisplayName("lazy - lazy 위임과 최초 접근 초기화")
    fun lazy() {
        assertEquals(listOf(0, 42, 42, 1), Subject.lazy())
    }

    @Test
    @DisplayName("observable - observable, 람다 매개변수 생략 _")
    fun observable() {
        assertEquals(listOf("old->new"), Subject.observable())
    }

    @Test
    @DisplayName("vetoable - vetoable")
    fun vetoable() {
        assertEquals(3, Subject.vetoable())
    }

    @Test
    @DisplayName("customDelegate - 커스텀 getValue/setValue 위임")
    fun customDelegate() {
        assertEquals("Seil", Subject.customDelegate())
    }

    @Test
    @DisplayName("mapDelegate - Map 프로퍼티 위임")
    fun mapDelegate() {
        assertEquals("Kotlin", Subject.mapDelegate())
    }

    @Test
    @DisplayName("interfaceDelegate - 인터페이스 구현 위임 by")
    fun interfaceDelegate() {
        assertEquals("Hello", Subject.interfaceDelegate())
    }
}
