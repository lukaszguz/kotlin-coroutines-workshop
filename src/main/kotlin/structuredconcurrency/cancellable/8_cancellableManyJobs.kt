package structuredconcurrency.cancellable

import LogClass.Companion.log
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
    val job = launch {
        repeat(100) { i ->
            log("Job: I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
    log("I'm tired of waiting!")
    job.cancelAndJoin()
}