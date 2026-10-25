package com.example.kotlinpractice.exercises.nullability

/** 공식 문서: https://kotlinlang.org/docs/null-safety.html */
object Nullability {
    /** nullable, safe call, Elvis. */
    fun length(text: String?): Int {
        TODO("nullable, safe call, Elvis")
    }

    /** 안전한 형 변환 as?. */
    fun cast(value: Any): String? {
        TODO("안전한 형 변환 as?")
    }

    /** !is와 조기 반환을 통한 스마트 캐스트. */
    fun smartCast(value: Any): Int {
        TODO("!is와 조기 반환을 통한 스마트 캐스트")
    }

    /** throw 표현식, Nothing. */
    fun required(value: String?): String {
        TODO("throw 표현식, Nothing")
    }

    /** !!의 성공과 실패를 안전한 테스트로 관찰. */
    fun asserted(value: String?): Int {
        TODO("!!의 성공과 실패를 안전한 테스트로 관찰")
    }

    /** 명시적 형 변환 as. */
    fun strictCast(value: Any): Int {
        TODO("명시적 형 변환 as")
    }
}
