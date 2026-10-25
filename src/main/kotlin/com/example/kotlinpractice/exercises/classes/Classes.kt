package com.example.kotlinpractice.exercises.classes

private abstract class Shape(protected val size: Int) {
    abstract fun area(): Int

    open fun label() = "shape"
}

private interface Named {
    fun label(): String = "named"
}

private class Square(size: Int) : Shape(size), Named {
    override fun area() = size * size

    override fun label() = super<Shape>.label() + ":" + super<Named>.label()
}

private class Account private constructor(val name: String, initial: Int) {
    var balance: Int = initial
        private set

    init {
        require(initial >= 0)
    }

    constructor(name: String) : this(name, 0)

    fun deposit(amount: Int) {
        require(amount > 0)
        balance += amount
    }

    companion object {
        fun funded(name: String, balance: Int) = Account(name, balance)
    }
}

private class Outer(val value: Int) {
    class Nested {
        fun answer() = 42
    }

    inner class Inner {
        fun value() = this@Outer.value
    }
}

private object Defaults {
    const val LANGUAGE = "Kotlin"
}

/** 공식 문서: https://kotlinlang.org/docs/classes.html */
object Classes {
    /** abstract, open, override, protected, super, 인터페이스 기본 구현. */
    fun inheritance(): String {
        TODO("abstract, open, override, protected, super, 인터페이스 기본 구현")
    }

    /** 주·부 생성자, init, private set, companion object. */
    fun constructors(): List<Int> {
        TODO("주·부 생성자, init, private set, companion object")
    }

    /** 중첩 클래스, inner, this@Outer. */
    fun nested(): List<Int> {
        TODO("중첩 클래스, inner, this@Outer")
    }

    /** object 선언과 object 표현식. */
    fun anonymousObject(): String {
        TODO("object 선언과 object 표현식")
    }

    /** 지역 클래스와 바깥 변수 캡처. */
    fun localClass(prefix: String): String {
        TODO("지역 클래스와 바깥 변수 캡처")
    }
}
