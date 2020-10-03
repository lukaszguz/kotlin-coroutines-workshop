package builder

import LogClass.Companion.log
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main() {
    asyncCalculation()
}

private fun asyncCalculation() = runBlocking {
    val time = measureTimeMillis {
        val result = 1
        require(result == 3) { "Correct answer is 3 not $result" }
    }
    log("Completed in $time ms")
    require(time < 2000) { "Too long!" }
}

private fun return1After1000ms(): Int {
    return 1
}

private fun return2After1000ms(): Int {
    return 2
}