package structuredconcurrency.throwexception

import LogClass.Companion.logger
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import runBlockingWithName

fun main() = runBlockingWithName {
    sum()
}

private suspend fun sum() = coroutineScope {
    val one = async { return1() }
    val two = async { failedReturn2() }
    one.await() + two.await()
}

private suspend fun return1(): Int {
    delay(1000_000)
    return 1
}

private fun failedReturn2(): Int {
    throw ArithmeticException(":(")
}