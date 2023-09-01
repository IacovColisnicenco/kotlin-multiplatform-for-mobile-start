package com.prototypebyiacov.dev.kotlinmultiplatformsandbox

import RocketLaunch
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import  kotlinx.datetime.*


class Greeting {
    private val platform: Platform = getPlatform()
    @Throws(Exception::class)
    suspend  fun greet(): String {


        val rockets: List<RocketLaunch> =

            httpClient.get("https://api.spacexdata.com/v4/launches").body()
                val lastSuccessLaunch = rockets.last { it.launchSuccess == true }

        return "Guess what it is! > ${platform.name.reversed()}!" +
                "\nThere are only ${daysUntilNewYear()} days left until New Year! 🎆" +
                "\nThe last successful launch was ${lastSuccessLaunch.launchDateUTC} 🚀"
    }




    //HTTPClien instance
    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            })
        }
    }
}