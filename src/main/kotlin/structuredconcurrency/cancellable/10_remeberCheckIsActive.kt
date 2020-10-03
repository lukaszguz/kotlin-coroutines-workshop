package structuredconcurrency.cancellable

import LogClass.Companion.log
import kotlinx.coroutines.*
import runBlockingWithName

fun main() = runBlockingWithName {
    val job = launch(Dispatchers.Default) {
        var i = 0
        while (i < 10) {
            log("job ${i++}: I'm wasting cpu ...")
            Thread.sleep(200)
        }
    }
    delay(1100) // delay a bit
    log("I'm tired of waiting!")
    job.cancelAndJoin()
}