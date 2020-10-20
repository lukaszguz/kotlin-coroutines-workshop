package flow

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeoutOrNull
import runBlockingWithName

fun main() = runBlockingWithName {
    withTimeoutOrNull(150) {
        launch(CoroutineName("launch")) {
            simple()
                    .map { request -> performRequest(request) }
                    .collect { response -> log(response) }
        }
    }
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