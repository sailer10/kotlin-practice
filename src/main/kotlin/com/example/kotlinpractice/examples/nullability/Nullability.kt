package com.example.kotlinpractice.examples.nullability

/** 공식 문서: https://kotlinlang.org/docs/null-safety.html */
object Nullability {
    /** nullable, safe call, Elvis. */
    fun length(text: String?): Int {
        return text?.length ?: 0
    }

    /** 안전한 형 변환 as?. */
    fun cast(value: Any): String? {
        return (value as? String)?.uppercase()
    }

    /** !is와 조기 반환을 통한 스마트 캐스트. */
    fun smartCast(value: Any): Int {
        if (value !is String) return -1
        return value.length
    }

    /** throw 표현식, Nothing. */
    fun required(value: String?): String {
        return value ?: throw IllegalArgumentException("value required")
    }

    /** !!의 성공과 실패를 안전한 테스트로 관찰. */
    fun asserted(value: String?): Int {
        return value!!.length
    }

    /** 명시적 형 변환 as. */
    fun strictCast(value: Any): Int {
        return (value as String).length
    }
}
