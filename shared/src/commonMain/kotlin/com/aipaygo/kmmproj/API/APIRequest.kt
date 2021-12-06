package com.aipaygo.kmmproj.API

import com.aipaygo.kmmproj.Model.CoffeeModel.CoffeeModel
import com.aipaygo.kmmproj.Model.CucinaModel.Data
import com.aipaygo.kmmproj.Model.CucinaModel.Orders
import com.aipaygo.kmmproj.initLogger
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*

class APIRequest {

    private val BASE_URL = "https://random-data-api.com/api/coffee/random_coffee"
    private val BASE_URL2 = "https://cucina.fund/api/orders"
    private val httpClient = HttpClient() {
        engine {
            pipelining = true
            threadsCount = 4
        }

        install(Logging){
            level = LogLevel.HEADERS
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "Bruh", message = message)
                }
            }
        }

        install(JsonFeature){
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
            }
            serializer = KotlinxSerializer(json)
        }
    }.also { initLogger() }

    @Throws(Exception::class)
    suspend fun coffeeInfo(): String {
        //return "${getCoffee().id}: ${getCoffee().blend_name}\n${getCoffee().notes}"
        return "${getOrders().data[1].id}: ${getOrders().data[1].name}"
    }

    suspend fun orderInfo(): Orders {
        return getOrders()
    }

    private suspend fun getCoffee(): Orders {
        return httpClient.get(BASE_URL)
    }

    private suspend fun getOrders(): Orders {
        return httpClient.get(BASE_URL2)
    }

}