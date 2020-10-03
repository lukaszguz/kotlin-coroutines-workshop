package builder

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import runBlockingWithName

fun main() = runBlockingWithName {
    forLoop("A")
    forLoop("B")
}

private fun forLoop(param: String) {
    (1..10).forEach {
        log("$param: $it")
    }
}