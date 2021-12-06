package com.aipaygo.kmmproj

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class Greeting {

    private val BASE_URL = "https://random-data-api.com/api/coffee/random_coffee"
    private val httpClient = HttpClient()

    suspend fun greeting(): String {
        return "${getCoffee()}"
    }

    private suspend fun getCoffee(): String {
        val response: HttpResponse = httpClient.get(BASE_URL)
        return response.readText()
    }
}