package structuredconcurrency.cancellable

import LogClass.Companion.log
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
    val job = launch {
        try {
            repeat(100) { i ->
                log("Job: I'm sleeping $i ...")
                delay(500L)
            }
        } finally {
            println("job: I'm running finally")
        }
    }
    delay(1300L)
    log("I'm tired of waiting!")
    job.cancelAndJoin()
}