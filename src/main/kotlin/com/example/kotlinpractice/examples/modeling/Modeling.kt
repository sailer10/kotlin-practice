package com.example.kotlinpractice.examples.modeling

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
        val original = Learner("Seil", 1)
        val upgraded = original.copy(level = 2)
        val (name, level) = upgraded
        return "$name:$level:${original == upgraded}"
    }

    /** enum class, entries, valueOf, ordinal. */
    fun enums(): List<Int> {
        return Stage.entries.map { it.rank } + Stage.valueOf("DONE").ordinal
    }

    /** sealed interface, data object, exhaustive when. */
    fun sealed(empty: Boolean): Int {
        val result: Outcome = if (empty) Outcome.Empty else Outcome.Success(3)
        return when (result) {
            is Outcome.Success -> result.value
            Outcome.Empty -> 0
        }
    }

    /** value class와 @JvmInline. */
    fun valueClass(id: Long): Long {
        val recordId = RecordId(id)
        return recordId.value
    }

    /** fun interface와 SAM 변환. */
    fun sam(): String {
        val formatter = Formatter { it.uppercase() }
        return formatter.format("kotlin")
    }

    /** 최상위·중첩 typealias. */
    fun aliases(): Int {
        val names: Names = listOf("Kotlin")
        val index: Catalog.Index = Catalog().index
        return index.getValue(names.single())
    }

    /** ==, ===, !==. */
    fun equality(): List<Boolean> {
        val first = Learner("A", 1)
        val second = first.copy()
        return listOf(first == second, first === second, first !== second)
    }
}
