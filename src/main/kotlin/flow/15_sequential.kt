package flow

import LogClass.Companion.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import runBlockingWithName

fun main() = runBlockingWithName {

}

private suspend fun performRequest(request: Int): String {
    delay(1000)
    return "response $request"
}