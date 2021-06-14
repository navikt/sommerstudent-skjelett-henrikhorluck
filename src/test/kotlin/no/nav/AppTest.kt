package no.nav

import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AppTest {

    @Test
    fun `Application launches with health checks`() {
        withTestApplication({ module() }) {
            with(handleRequest(HttpMethod.Get, "/isalive")) {
                assertEquals("isalive", response.content)
                assertEquals(HttpStatusCode.OK, response.status())
            }
            with(handleRequest(HttpMethod.Get, "/isready")) {
                assertEquals("isready", response.content)
                assertEquals(HttpStatusCode.OK, response.status())
            }
        }
    }
}