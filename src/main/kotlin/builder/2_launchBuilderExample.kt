package builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import runBlockingWithName
import java.util.concurrent.atomic.AtomicLong


fun main() {
}

private fun runBlockingExample() {
}

private fun launchAnimation() = runBlocking {
}

private fun createOneMillionCoroutines() {
    val counter = AtomicLong()
    runBlockingWithName {
        repeat(1_000_000) {
            launch {
                counter.addAndGet(it.toLong())
            }
        }
    }
}