package builder

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import runBlockingWithName
import java.util.concurrent.atomic.AtomicLong


fun main() {
    runBlockingExample()
    launchAnimation()
    createOneMillionCoroutines()
}

private fun runBlockingExample() {
    runBlocking {
        delay(500)
        print("Hello ")
    }
    print("World!")
}

private fun launchAnimation() = runBlocking {
    launch {
        delay(500)
        print("World!")
    }
    print("Hello ")
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