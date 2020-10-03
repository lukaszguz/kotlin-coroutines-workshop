package structuredconcurrency.cancellable

import kotlinx.coroutines.*
import iHaveToFinished
import runBlockingWithName

fun main() = runBlockingWithName {
    val job = launch {
        withContext(NonCancellable) {
            launch {
                iHaveToFinished()
            }
        }
    }
    delay(10)
    job.cancelAndJoin()
}