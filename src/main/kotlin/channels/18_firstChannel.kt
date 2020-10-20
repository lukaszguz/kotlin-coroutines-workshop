package channels

import LogClass.Companion.log
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
    val channel = Channel<Int>()
    launch {
        for (x in 1..5) channel.send(x)
        channel.close()
    }

    repeat(5) {
        log(channel.receive())
    }

    for (msg in channel) {
        log(msg)
    }
}