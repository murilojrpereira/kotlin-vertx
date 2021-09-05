package utils

import io.netty.util.internal.logging.InternalLogger
import io.netty.util.internal.logging.Slf4JLoggerFactory

interface UseLogger {
    val logger: InternalLogger
        get() = Slf4JLoggerFactory.getInstance(this::class.java)
}
