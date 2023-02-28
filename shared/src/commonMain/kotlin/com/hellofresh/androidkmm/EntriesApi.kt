package com.hellofresh.androidkmm

import com.hellofresh.androidkmm.model.Entries
import com.hellofresh.androidkmm.model.Input
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class ApiClass {

   private val httpClient = HttpClient {
      install(ContentNegotiation) {
         json(Json {
            ignoreUnknownKeys = true
            useAlternativeNames = false
         })
      }
   }

   suspend fun getEntries() : Input = httpClient.get("https://api.publicapis.org/entries").body()

}