package com.example.kotlinpractice.examples.properties

import kotlin.properties.Delegates
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
        val profile = Profile()
        profile.score = -3
        val low = profile.score
        profile.score = 4
        return listOf(low, profile.score)
    }

    /** lateinit와 isInitialized. */
    fun lateinit(): List<Boolean> {
        val profile = Profile()
        val before = profile.ready
        profile.language = "Kotlin"
        return listOf(before, profile.ready)
    }

    /** lazy 위임과 최초 접근 초기화. */
    fun lazy(): List<Int> {
        var calls = 0
        val answer by lazy {
            calls++
            42
        }
        return listOf(calls, answer, answer, calls)
    }

    /** observable, 람다 매개변수 생략 _. */
    fun observable(): List<String> {
        val changes = mutableListOf<String>()
        var name by Delegates.observable("old") { _, old, new -> changes += "$old->$new" }
        name = "new"
        return changes
    }

    /** vetoable. */
    fun vetoable(): Int {
        var value by Delegates.vetoable(0) { _, _, new -> new >= 0 }
        value = 3
        value = -1
        return value
    }

    /** 커스텀 getValue/setValue 위임. */
    fun customDelegate(): String {
        val profile = Profile()
        profile.name = "  Seil  "
        return profile.name
    }

    /** Map 프로퍼티 위임. */
    fun mapDelegate(): String {
        val values = mapOf("name" to "Kotlin")
        val name: String by values
        return name
    }

    /** 인터페이스 구현 위임 by. */
    fun interfaceDelegate(): String {
        return Delegating(English()).greet()
    }
}
