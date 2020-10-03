package channels

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
}

data class PingPongBall(var hits: Int)