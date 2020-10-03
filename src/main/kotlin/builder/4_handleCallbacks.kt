package builder

import LogClass.Companion.log
import LogClass.Companion.logger
import kotlinx.coroutines.suspendCancellableCoroutine
import runBlockingWithName
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

fun main() = runBlockingWithName {
    val future = CompletableFuture.supplyAsync {
        log("Produce ...")
        "Hello!"
    }
    log(future.await())

    try {
        CompletableFuture.failedFuture<String>(RuntimeException("Ops")).await()
    } catch (ex: Exception) {
        logger.error("Oh", ex)
    }
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