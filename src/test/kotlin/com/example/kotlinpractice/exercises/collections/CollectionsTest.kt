package com.example.kotlinpractice.exercises.collections

import com.example.kotlinpractice.exercises.collections.Collections as Subject
import kotlin.test.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

@Tag("exercise")
class CollectionsTest {
    @Test
    @DisplayName("pipeline - filter, map, distinct, sorted")
    fun pipeline() {
        assertEquals(listOf(2, 6), Subject.pipeline(listOf(3, -1, 1, 3)))
        assertEquals(emptyList(), Subject.pipeline(emptyList()))
    }

    @Test
    @DisplayName("grouping - Map, Pair, groupBy")
    fun grouping() {
        assertEquals(mapOf(1 to listOf("a", "b"), 2 to listOf("cc")), Subject.grouping())
    }

    @Test
    @DisplayName("aggregate - fold, reduce, sumOf와 함수 참조")
    fun aggregate() {
        assertEquals(listOf(16, 6, 14), Subject.aggregate())
    }

    @Test
    @DisplayName("partition - partition과 구조 분해 가능한 Pair")
    fun partition() {
        assertEquals(listOf(2, 4) to listOf(1, 3), Subject.partition())
    }

    @Test
    @DisplayName("sequence - 지연 시퀀스와 무한 시퀀스 제한")
    fun sequence() {
        assertEquals(listOf(2, 4, 6), Subject.sequence())
    }

    @Test
    @DisplayName("builder - 컬렉션 builder")
    fun builder() {
        assertEquals(listOf(1, 2, 3), Subject.builder())
    }

    @Test
    @DisplayName("operations - Set, mutable 컬렉션, flatMap, associateWith")
    fun operations() {
        assertEquals(listOf(1, -1, 2, -2, 3, -3, 1, 2), Subject.operations())
    }

    @Test
    @DisplayName("predicates - any, all, none, !in")
    fun predicates() {
        assertEquals(listOf(true, true, true, true), Subject.predicates())
    }
}
