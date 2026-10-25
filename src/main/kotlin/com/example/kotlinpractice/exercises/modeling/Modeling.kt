package com.example.kotlinpractice.exercises.modeling

private data class Learner(val name: String, val level: Int)

private enum class Stage(val rank: Int) {
    TODO(0),
    DONE(1),
}

private sealed interface Outcome {
    data class Success(val value: Int) : Outcome

    data object Empty : Outcome
}

@JvmInline private value class RecordId(val value: Long)

private fun interface Formatter {
    fun format(value: String): String
}

private typealias Names = List<String>

private class Catalog {
    typealias Index = Map<String, Int>

    val index: Index = mapOf("Kotlin" to 1)
}

/** 공식 문서: https://kotlinlang.org/docs/data-classes.html */
object Modeling {
    /** data class, copy, 구조 분해, 값 동등성. */
    fun data(): String {
        TODO("data class, copy, 구조 분해, 값 동등성")
    }

    /** enum class, entries, valueOf, ordinal. */
    fun enums(): List<Int> {
        TODO("enum class, entries, valueOf, ordinal")
    }

    /** sealed interface, data object, exhaustive when. */
    fun sealed(empty: Boolean): Int {
        TODO("sealed interface, data object, exhaustive when")
    }

    /** value class와 @JvmInline. */
    fun valueClass(id: Long): Long {
        TODO("value class와 @JvmInline")
    }

    /** fun interface와 SAM 변환. */
    fun sam(): String {
        TODO("fun interface와 SAM 변환")
    }

    /** 최상위·중첩 typealias. */
    fun aliases(): Int {
        TODO("최상위·중첩 typealias")
    }

    /** ==, ===, !==. */
    fun equality(): List<Boolean> {
        TODO("==, ===, !==")
    }
}
