package com.example.kotlinpractice.exercises.dsl

@DslMarker private annotation class StudyDsl

@StudyDsl
private class LessonBuilder {
    private val titles = mutableListOf<String>()

    fun lesson(title: String) {
        titles += title
    }

    fun build() = titles.toList()
}

private fun course(block: LessonBuilder.() -> Unit) = LessonBuilder().apply(block).build()

/** 공식 문서: https://kotlinlang.org/docs/type-safe-builders.html */
object Dsl {
    /** @DslMarker, 수신 객체 람다, 타입 안전 builder. */
    fun build(): List<String> {
        TODO("@DslMarker, 수신 객체 람다, 타입 안전 builder")
    }

    /** multi-dollar 문자열 보간. */
    fun multiDollar(): String {
        TODO("multi-dollar 문자열 보간")
    }

    /** 명시적 반환 타입 표현식 본문에서 return. */
    fun expressionReturn(value: String?): String {
        TODO("명시적 반환 타입 표현식 본문에서 return")
    }
}
