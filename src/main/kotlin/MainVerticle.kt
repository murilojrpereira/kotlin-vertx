import io.netty.util.internal.logging.Slf4JLoggerFactory
import io.vertx.core.Vertx
import io.vertx.core.json.Json
import io.vertx.ext.web.Router

private val logger = Slf4JLoggerFactory.getInstance("main")

fun main(args: Array<String>) {

    val vertx = Vertx.vertx()
    val httpServer = vertx.createHttpServer()

    val router = Router.router(vertx)

    router.get("/health")
        .handler { routingContext ->
            routingContext.request().response()
                .end(checkHealth())
        }

    router.get("/json/:name")
        .handler { routingContext ->

            val request = routingContext.request()
            val name = request.getParam("name")
            val response = routingContext.response()
            response.putHeader("content-type", "application/json")
                .end(Json.encodePrettily(ResponseObj("Hello, " + name)))
        }

    httpServer
        .requestHandler(router)
        .listen(8091)

    logger.info("cxvxcvxc")
}

fun checkHealth(): String {
    logger.info("Health Check")
    return "up"
}

data class ResponseObj(var name:String = "")
