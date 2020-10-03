import LogClass.Companion.log
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.system.measureTimeMillis

fun runBlockingWithName(block: suspend CoroutineScope.() -> Unit) {
    return runBlocking(CoroutineName("runBlocking")) {
        val millis = measureTimeMillis {
            block()
        }
        log("Now I can quit. Duration $millis ms")
    }
}

suspend fun iHaveToFinished() {
    log("I have to finished")
    delay(1000)
    log("I've finished")
}

suspend fun return1After1000ms(): Int {
    delay(1000L)
    return 1
}

suspend fun return2After1000ms(): Int {
    delay(1000L)
    return 2
}

class LogClass {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(LogClass::class.java.name)
        fun log(vararg args: Any) {
            if (args.size > 1) {
                logger.info(args[0].toString(), *args.copyOfRange(1, args.size))
            } else {
                logger.info(args[0].toString())
            }
        }
    }
}