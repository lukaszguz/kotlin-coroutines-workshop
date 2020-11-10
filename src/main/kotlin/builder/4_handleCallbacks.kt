package builder

import LogClass.Companion.log
import LogClass.Companion.logger
import kotlinx.coroutines.suspendCancellableCoroutine
import runBlockingWithName
import java.lang.RuntimeException
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

fun main() = runBlockingWithName {
    val future = CompletableFuture.supplyAsync {
        log("Produce")
        "Hello"
    }
    require(future.await() == "Hello")

    CompletableFuture.failedFuture<String>(RuntimeException("OOOOOOOO!")).await()
}


private suspend fun <T> CompletableFuture<T>.await(): T {
    return suspendCancellableCoroutine { continuation ->
        this.handle { value, ex ->
            if (ex != null) {
                continuation.resumeWithException(ex)
            } else {
                continuation.resume(value)
            }
        }
    }
}