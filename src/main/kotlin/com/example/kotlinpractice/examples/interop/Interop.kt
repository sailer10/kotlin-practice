package com.example.kotlinpractice.examples.interop

import com.example.kotlinpractice.interop.JavaGreeter
import java.util.Locale as JavaLocale
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.full.memberProperties

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
        val text: String? = JavaGreeter.maybeName(false)
        return JavaGreeter.greet(text ?: "world")
    }

    /** 같은 패키지의 JavaCaller로 @JvmStatic, @JvmOverloads, @JvmField를 관찰한다. */
    fun javaCallsKotlin(): String {
        return JavaCaller.callKotlin()
    }

    /** annotation class, target, retention, ::class, reflection. */
    fun reflection(): String {
        val type = Tagged::class
        val label = type.findAnnotation<Topic>()!!.name
        val property = type.memberProperties.single().name
        return "$label:$property"
    }

    /** import as 별칭과 Java Locale. */
    fun aliasImport(): String {
        return "kotlin".uppercase(JavaLocale.ROOT)
    }
}
