package com.example.kotlinpractice.exercises.properties

import kotlin.reflect.KProperty

private class Trimmed {
    private var value = ""

    operator fun getValue(thisRef: Any?, property: KProperty<*>) = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: String) {
        value = newValue.trim()
    }
}

private class Profile {
    var name: String by Trimmed()
    lateinit var language: String
    val ready: Boolean
        get() = this::language.isInitialized

    var score = 0
        set(value) {
            field = value.coerceAtLeast(0)
        }
}

private interface Greeting {
    fun greet(): String
}

private class English : Greeting {
    override fun greet() = "Hello"
}

private class Delegating(private val target: Greeting) : Greeting by target

/** 공식 문서: https://kotlinlang.org/docs/delegated-properties.html */
object Properties {
    /** 커스텀 접근자와 backing field. */
    fun accessors(): List<Int> {
        TODO("커스텀 접근자와 backing field")
    }

    /** lateinit와 isInitialized. */
    fun lateinit(): List<Boolean> {
        TODO("lateinit와 isInitialized")
    }

    /** lazy 위임과 최초 접근 초기화. */
    fun lazy(): List<Int> {
        TODO("lazy 위임과 최초 접근 초기화")
    }

    /** observable, 람다 매개변수 생략 _. */
    fun observable(): List<String> {
        TODO("observable, 람다 매개변수 생략 _")
    }

    /** vetoable. */
    fun vetoable(): Int {
        TODO("vetoable")
    }

    /** 커스텀 getValue/setValue 위임. */
    fun customDelegate(): String {
        TODO("커스텀 getValue/setValue 위임")
    }

    /** Map 프로퍼티 위임. */
    fun mapDelegate(): String {
        TODO("Map 프로퍼티 위임")
    }

    /** 인터페이스 구현 위임 by. */
    fun interfaceDelegate(): String {
        TODO("인터페이스 구현 위임 by")
    }
}
