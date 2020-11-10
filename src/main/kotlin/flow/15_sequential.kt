package flow

import LogClass.Companion.log
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import runBlockingWithName

fun main() = runBlockingWithName {
            simple()
                    .map { request -> performRequest(request) }
                    .collect { response -> log(response) }
}

private fun simple() = flow {
    for (i in 1..3) {
        log("Emit $i")
        emit(i)
    }
}

private suspend fun performRequest(request: Int): String {
    delay(1000)
    return "response $request"
}