package com.example.kotlinpractice.exercises.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/** 공식 문서: https://kotlinlang.org/docs/coroutines-overview.html */
object Coroutines {
    /** suspend, coroutineScope, async/await, delay. */
    suspend fun concurrent(): Int {
        TODO("suspend, coroutineScope, async/await, delay")
    }

    /** launch, Job, join. */
    suspend fun launch(): Int {
        TODO("launch, Job, join")
    }

    /** Flow builder, emit와 중간·최종 연산. */
    suspend fun flow(): List<Int> {
        TODO("Flow builder, emit와 중간·최종 연산")
    }

    /** 시작 여부, 취소 여부, finally 정리 여부를 순서대로 반환. */
    suspend fun cancel(): List<Boolean> {
        TODO("시작 여부, 취소 여부, finally 정리 여부를 순서대로 반환")
    }

    /** Channel, send, 순회 수신, close. */
    suspend fun channel(): List<Int> {
        TODO("Channel, send, 순회 수신, close")
    }
}
