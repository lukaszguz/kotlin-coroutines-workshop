package structuredconcurrency.cancellable

import kotlinx.coroutines.launch
import kotlinx.coroutines.withTimeout
import iHaveToFinished
import runBlockingWithName

fun main() = runBlockingWithName {
    withTimeout(200) {
        iHaveToFinished()
    }
}