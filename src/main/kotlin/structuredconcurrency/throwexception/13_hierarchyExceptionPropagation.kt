package structuredconcurrency.throwexception

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import LogClass.Companion.logger
import runBlockingWithName

fun main() = runBlockingWithName {
    try {
        sum()
    } catch (e: ArithmeticException) {
        logger.error("Ups! {}", e::class.java)
    }
}

private suspend fun sum() = coroutineScope {
    val one = async { return1() }
    val two = async { failedReturn2() }
    one.await() + two.await()
}

private suspend fun return1(): Int {
    return try {
        delay(1000_000L)
        1
    } catch (e: Exception) {
        logger.error("OOO! {}, message: {}", e::class.java, e.message)
        1
    }
}

private fun failedReturn2(): Int {
    throw ArithmeticException("Wow!")
}