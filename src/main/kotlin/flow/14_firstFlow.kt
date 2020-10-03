package flow

import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
    launch(CoroutineName("for")) {
        (1..3).forEach {
            log("I'm not blocked $it")
            delay(100)
        }
    }
}