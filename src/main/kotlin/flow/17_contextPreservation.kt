package flow

import LogClass.Companion.log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import runBlockingWithName

fun main() = runBlockingWithName {
    contextFromCollect()
}

private suspend fun contextFromCollect() = coroutineScope {
    simple()
            .map { request -> performRequest(request) }
            .collect { response -> log(response) }
}

private suspend fun shortcutOfLaunch() = coroutineScope {
    simple()
            .map { request -> performRequest(request) }
            .onEach { response -> log(response) }
}

private suspend fun contextFromFlowOn() {
    simple()
            .map { request -> performRequest(request) }
            .collect { response -> log(response) }
}

private suspend fun contextForProducerAndConsumer() {
    simple()
            .map { request -> performRequest(request) }
            .collect { response -> log(response) }
}

private fun simple() = flow {
    for (i in 1..3) {
        Thread.sleep(100)
        log("Emit $i")
        emit(i)
    }
}

private suspend fun performRequest(request: Int): String {
    delay(1000)
    return "response $request"
}