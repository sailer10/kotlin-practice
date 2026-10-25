package com.example.kotlinpractice.examples.classes

import com.example.kotlinpractice.examples.classes.Classes as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ClassesTest {
    @Test
    @DisplayName("inheritance - abstract, open, override, protected, super, 인터페이스 기본 구현")
    fun inheritance() {
        assertEquals("shape:named:16", Subject.inheritance())
    }

    @Test
    @DisplayName("constructors - 주·부 생성자, init, private set, companion object")
    fun constructors() {
        assertEquals(listOf(3, 5), Subject.constructors())
    }

    @Test
    @DisplayName("nested - 중첩 클래스, inner, this@Outer")
    fun nested() {
        assertEquals(listOf(42, 7), Subject.nested())
    }

    @Test
    @DisplayName("anonymousObject - object 선언과 object 표현식")
    fun anonymousObject() {
        assertEquals("Kotlin", Subject.anonymousObject())
    }

    @Test
    @DisplayName("localClass - 지역 클래스와 바깥 변수 캡처")
    fun localClass() {
        assertEquals("study:learner", Subject.localClass("study"))
    }
}
