package channels

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consume
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import runBlockingWithName

fun main() = runBlockingWithName {
    val numbers = produceNumbers()
    val squares = square(numbers)
    repeat(5){
        log(squares.receive())
    }
    coroutineContext.cancelChildren()
}

private fun CoroutineScope.produceNumbers() = produce<Int> {
    var x = 1
    while (x < 400) send(x++)
}

private fun CoroutineScope.square(numbers: ReceiveChannel<Int>): ReceiveChannel<Int> = produce {
    for (x in numbers) send(x * x)
}