package structuredconcurrency.cancellable

import LogClass.Companion.log
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import LogClass.Companion.logger
import runBlockingWithName

fun main() = runBlockingWithName {
    val job = launch {
        log("Start one")
        launch {
            log("Start two")
            launch {
                log("Start three")
                delay(5000)
            }
            delay(2000)
        }
        delay(1000)
    }
    delay(200)
    job.cancelAndJoin()
}