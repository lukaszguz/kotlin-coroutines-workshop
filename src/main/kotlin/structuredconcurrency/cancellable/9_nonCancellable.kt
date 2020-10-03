package structuredconcurrency.cancellable

import kotlinx.coroutines.*
import iHaveToFinished
import runBlockingWithName

fun main() = runBlockingWithName {
    val job = launch { iHaveToFinished() }
}