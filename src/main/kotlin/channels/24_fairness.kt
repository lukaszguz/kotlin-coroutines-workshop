package channels

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
    val table = Channel<PingPongBall>()
    launch(CoroutineName("ping")) { player(table) }
    launch(CoroutineName("pong")) { player(table) }
    table.send(PingPongBall(0))
    delay(1500)
    coroutineContext.cancelChildren()
}

data class PingPongBall(var hits: Int)

suspend fun player(table: Channel<PingPongBall>) {
    for (ball in table) {
        ball.hits++
        log("$ball")
        delay(300)
        table.send(ball)
    }
}