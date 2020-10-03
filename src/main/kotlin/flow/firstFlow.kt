package flow

import LogClass.Companion.log
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import runBlockingWithName

fun main() = runBlockingWithName {
    launch {
        for (i in 1..3) {
            log("I'm not blocked $i")
            delay(100)
        }
    }

    simple().collect { value -> log(value) }
}

private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}