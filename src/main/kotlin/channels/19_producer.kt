package channels

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import runBlockingWithName

fun main() = runBlockingWithName {
    val squares = receiveChannel()
    squares.consumeEach {
        log(it)
    }
}

private suspend fun CoroutineScope.receiveChannel() =
        produce {
            for (x in 1..5) send(x * x)
        }
