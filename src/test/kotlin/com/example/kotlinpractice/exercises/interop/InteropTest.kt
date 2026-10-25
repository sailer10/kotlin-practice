package com.example.kotlinpractice.exercises.interop

import com.example.kotlinpractice.exercises.interop.Interop as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class InteropTest {
    @Test
    @DisplayName("javaCall - Java 호출, 플랫폼 타입을 nullable로 경계 처리")
    fun javaCall() {
        assertEquals("Hello, world", Subject.javaCall())
    }

    @Test
    @DisplayName("javaCallsKotlin - @JvmStatic, @JvmOverloads, @JvmField")
    fun javaCallsKotlin() {
        assertEquals("Hello, world:Kotlin", Subject.javaCallsKotlin())
    }

    @Test
    @DisplayName("reflection - annotation class, target, retention, ::class, reflection")
    fun reflection() {
        assertEquals("language:title", Subject.reflection())
    }

    @Test
    @DisplayName("aliasImport - import as 별칭과 Java Locale")
    fun aliasImport() {
        assertEquals("KOTLIN", Subject.aliasImport())
    }
}
