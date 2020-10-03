package builder

import LogClass.Companion.log
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import return1After1000ms
import return2After1000ms
import kotlin.system.measureTimeMillis


fun main() {
    sequential()
    reallyAsync()
}

private fun sequential() = runBlocking {
    val time = measureTimeMillis {
        val one = return1After1000ms()
        val two = return2After1000ms()
        val result = one + two

        log("The answer is $result")
        require(result == 3)
    }
    log("Completed in $time ms")
    require(time < 2000) { "Too long!" }
}

private fun reallyAsync() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async { return1After1000ms() }
        val two = async { return2After1000ms() }
        val result = one.await() + two.await()

        log("The answer is $result")
        require(result == 3)
    }
    log("Completed in $time ms")
    require(time < 2000) { "Too long!" }
}