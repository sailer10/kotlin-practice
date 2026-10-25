package com.example.kotlinpractice.examples.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

/** 공식 문서: https://kotlinlang.org/docs/coroutines-overview.html */
object Coroutines {
    /** suspend, coroutineScope, async/await, delay. */
    suspend fun concurrent(): Int {
        return coroutineScope {
            val first = async {
                delay(1)
                20
            }
            val second = async { 22 }
            first.await() + second.await()
        }
    }

    /** launch, Job, join. */
    suspend fun launch(): Int {
        return coroutineScope {
            var value = 0
            val job = launch { value = 7 }
            job.join()
            value
        }
    }

    /** Flow builder, emit와 중간·최종 연산. */
    suspend fun flow(): List<Int> {
        return flow {
            emit(1)
            emit(2)
            emit(3)
        }
            .map { it * 2 }
            .filter { it > 2 }
            .toList()
    }

    /** 시작 여부, 취소 여부, finally 정리 여부를 순서대로 반환한다. */
    suspend fun cancel(): List<Boolean> {
        return coroutineScope {
            val started = CompletableDeferred<Unit>()
            var cleanedUp = false
            val job = launch {
                try {
                    started.complete(Unit)
                    awaitCancellation()
                } finally {
                    cleanedUp = true
                }
            }
            started.await()
            job.cancelAndJoin()
            listOf(started.isCompleted, job.isCancelled, cleanedUp)
        }
    }

    /** Channel, send, 순회 수신, close. */
    suspend fun channel(): List<Int> {
        return coroutineScope {
            val channel = Channel<Int>()
            launch {
                channel.send(1)
                channel.send(2)
                channel.close()
            }
            buildList { for (value in channel) add(value) }
        }
    }
}
