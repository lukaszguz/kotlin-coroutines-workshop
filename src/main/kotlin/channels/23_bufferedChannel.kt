package channels

import LogClass.Companion.log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
    val bufferedChannel = Channel<Int>(5)

    val sender = launch {
        (1..10).forEach {
            log("Sending $it")
            bufferedChannel.send(it)
        }
    }

    delay(1000)
    sender.cancel()
//    The first five elements are added to the buffer and the sender suspends when trying to send the sixth one.
}