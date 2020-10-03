package builder

import LogClass.Companion.log
import kotlinx.coroutines.suspendCancellableCoroutine
import runBlockingWithName
import java.util.concurrent.CompletableFuture
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

fun main() = runBlockingWithName {
    val future = CompletableFuture.supplyAsync { log("I'm working"); "Hello" }
    require(future.join() == "Hello")
}