package com.example.kotlinpractice.examples.collections

/** 공식 문서: https://kotlinlang.org/docs/collections-overview.html */
object Collections {
    /** filter, map, distinct, sorted. */
    fun pipeline(values: List<Int>): List<Int> {
        return values.filter { it > 0 }.map { it * 2 }.distinct().sorted()
    }

    /** Map, Pair, groupBy. */
    fun grouping(): Map<Int, List<String>> {
        return listOf("a", "b", "cc").groupBy { it.length }
    }

    /** fold, reduce, sumOf와 함수 참조. */
    fun aggregate(): List<Int> {
        val numbers = listOf(1, 2, 3)
        return listOf(
            numbers.fold(10) { acc, n -> acc + n },
            numbers.reduce(Int::plus),
            numbers.sumOf { it * it },
        )
    }

    /** partition과 구조 분해 가능한 Pair. */
    fun partition(): Pair<List<Int>, List<Int>> {
        return (1..4).partition { it % 2 == 0 }
    }

    /** 지연 시퀀스와 무한 시퀀스 제한. */
    fun sequence(): List<Int> {
        return generateSequence(1) { it + 1 }.filter { it % 2 == 0 }.take(3).toList()
    }

    /** 컬렉션 builder. */
    fun builder(): List<Int> {
        return buildList {
            add(1)
            addAll(listOf(2, 3))
        }
    }

    /** Set, mutable 컬렉션, flatMap, associateWith. */
    fun operations(): List<Int> {
        val source = mutableSetOf(1, 2, 2)
        source += 3
        val lookup = listOf("a", "bb").associateWith { it.length }
        return source.flatMap { listOf(it, -it) } + lookup.values
    }

    /** any, all, none, !in. */
    fun predicates(): List<Boolean> {
        val values = listOf(1, 2, 3)
        return listOf(
            values.any { it == 2 },
            values.all { it > 0 },
            values.none { it < 0 },
            4 !in values,
        )
    }
}
