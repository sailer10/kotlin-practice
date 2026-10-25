package com.example.kotlinpractice.exercises.interop

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
private annotation class Topic(val name: String)

@Topic("language") private data class Tagged(val title: String)

internal class KotlinBridge {
    companion object {
        @JvmStatic @JvmOverloads fun greeting(name: String = "world") = "Hello, $name"

        @JvmField val LANGUAGE: String = "Kotlin"
    }
}

/** 공식 문서: https://kotlinlang.org/docs/java-interop.html */
object Interop {
    /** Java 호출, 플랫폼 타입을 nullable로 경계 처리. */
    fun javaCall(): String {
        TODO("Java 호출, 플랫폼 타입을 nullable로 경계 처리")
    }

    /** 같은 패키지의 JavaCaller로 @JvmStatic, @JvmOverloads, @JvmField를 관찰한다. */
    fun javaCallsKotlin(): String {
        TODO("@JvmStatic, @JvmOverloads, @JvmField")
    }

    /** annotation class, target, retention, ::class, reflection. */
    fun reflection(): String {
        TODO("annotation class, target, retention, ::class, reflection")
    }

    /** import as 별칭과 Java Locale. */
    fun aliasImport(): String {
        TODO("import as 별칭과 Java Locale")
    }
}
