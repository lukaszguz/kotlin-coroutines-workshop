package flow

import LogClass.Companion.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import runBlockingWithName

fun main() = runBlockingWithName {
    buffer()
    conflate()
    latest()
}


private suspend fun buffer() {
    simple()
            .buffer(2)
            .map { request -> performRequest(request) }
            .collect { response -> log(response) }
}

private suspend fun conflate() {
    simple()
            .conflate()
            .map { request -> performRequest(request) }
            .collect { response -> log(response) }
}

private suspend fun latest() {
    simple()
            .collectLatest { request ->
                log("Collecting $request")
                val response = performRequest(request)
//                delay(300) // pretend we are processing it for 300 ms
                log("Done $response")
            }
}

private fun simple() = flow {
    for (i in 1..10) {
        delay(100)
        log("Emit $i")
        emit(i)
    }
}

private suspend fun performRequest(request: Int): String {
    log("Processing $request")
    delay(300)
    return "response $request"
}