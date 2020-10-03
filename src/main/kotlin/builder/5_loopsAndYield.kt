package builder

import LogClass.Companion.log
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import LogClass.Companion.logger
import runBlockingWithName

fun main() = runBlockingWithName {
    launch { forLoop() }
    launch { otherForLoop() }
}

private suspend fun forLoop() {
    (1..10).forEach {
        log("A: $it")
        yield()
    }
}

private suspend fun otherForLoop() {
    (100..110).forEach {
        log("B: $it")
        yield()
    }
}