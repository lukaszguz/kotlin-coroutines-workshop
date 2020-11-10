package builder

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import runBlockingWithName

fun main() = runBlockingWithName {
    launch(CoroutineName("A")) { forLoop("A") }
    launch(CoroutineName("B")) { forLoop("B") }
}

private suspend fun forLoop(param: String) {
    (1..10).forEach {
        log("$param: $it")
        yield()
    }
}