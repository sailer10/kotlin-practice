package com.example.kotlinpractice.examples.nullability

import com.example.kotlinpractice.examples.nullability.Nullability as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NullabilityTest {
    @Test
    @DisplayName("length - nullable, safe call, Elvis")
    fun length() {
        assertEquals(0, Subject.length(null))
        assertEquals(3, Subject.length("abc"))
    }

    @Test
    @DisplayName("cast - 안전한 형 변환 as?")
    fun cast() {
        assertNull(Subject.cast(3))
        assertEquals("OK", Subject.cast("ok"))
    }

    @Test
    @DisplayName("smartCast - !is와 조기 반환을 통한 스마트 캐스트")
    fun smartCast() {
        assertEquals(-1, Subject.smartCast(3))
        assertEquals(2, Subject.smartCast("ok"))
    }

    @Test
    @DisplayName("required - throw 표현식, Nothing")
    fun required() {
        assertEquals("ok", Subject.required("ok"))
        assertFailsWith<IllegalArgumentException> { Subject.required(null) }
    }

    @Test
    @DisplayName("asserted - !!의 성공과 실패를 안전한 테스트로 관찰")
    fun asserted() {
        assertEquals(2, Subject.asserted("ok"))
        assertFailsWith<NullPointerException> { Subject.asserted(null) }
    }

    @Test
    @DisplayName("strictCast - 명시적 형 변환 as")
    fun strictCast() {
        assertEquals(2, Subject.strictCast("ok"))
        assertFailsWith<ClassCastException> { Subject.strictCast(1) }
    }
}
