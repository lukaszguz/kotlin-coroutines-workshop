package builder

import LogClass.Companion.log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import runBlockingWithName


fun main() = runBlockingWithName {
    log("Run from runBlocking")

    GlobalScope.launch {
        log("start global")
        delay(100_000)
        log("kill")
    }
}