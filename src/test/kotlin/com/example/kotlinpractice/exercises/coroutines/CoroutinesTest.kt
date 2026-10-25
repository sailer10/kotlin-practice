package com.example.kotlinpractice.exercises.coroutines

import com.example.kotlinpractice.exercises.coroutines.Coroutines as Subject
import kotlin.test.*
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class CoroutinesTest {
    @Test
    @DisplayName("concurrent - suspend, coroutineScope, async/await, delay")
    fun concurrent() {
        assertEquals(42, runBlocking { Subject.concurrent() })
    }

    @Test
    @DisplayName("launch - launch, Job, join")
    fun launch() {
        assertEquals(7, runBlocking { Subject.launch() })
    }

    @Test
    @DisplayName("flow - Flow builder, emit와 중간·최종 연산")
    fun flow() {
        assertEquals(listOf(4, 6), runBlocking { Subject.flow() })
    }

    @Test
    @DisplayName("cancel - 코루틴 시작, 취소, finally 정리")
    fun cancel() {
        assertEquals(
            listOf(true, true, true),
            runBlocking { withTimeout(1000) { Subject.cancel() } },
        )
    }

    @Test
    @DisplayName("channel - Channel, send, 순회 수신, close")
    fun channel() {
        assertEquals(listOf(1, 2), runBlocking { Subject.channel() })
    }
}
