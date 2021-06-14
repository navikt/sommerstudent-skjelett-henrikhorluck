package no.nav

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*

fun main(args: Array<String>): Unit = io.ktor.server.jetty.EngineMain.main(args)

fun Application.module() {
    install(Routing) {
        HealthChecks()
        ProduceMessage()
    }
}

fun Route.HealthChecks() {
    get ("/isalive") {
        call.respond(status = HttpStatusCode.OK, message = "isalive")
    }

    get("/isready") {
        call.respond(status = HttpStatusCode.OK, message = "isready")
    }
}
