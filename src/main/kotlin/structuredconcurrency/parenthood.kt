package structuredconcurrency

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import runBlockingWithName


fun main() = runBlockingWithName {
    coroutineScope {
        log("Run from coroutineScope")
        launch(CoroutineName("father")) { father() }
    }
    log("Run from runBlocking")
}

private suspend fun father() {
    log("I have waiting for my son")
    coroutineScope {
        launch(CoroutineName("son")) { son() }
    }
    log("Father has finished")
}

private suspend fun son() {
    delay(200)
    log("Son has finished")
}