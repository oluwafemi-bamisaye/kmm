package com.hellofresh.androidkmm.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Entries(
    @SerialName("API")
    val api: String,
    @SerialName("Description")
    val desc: String,
    @SerialName("Auth")
    val auth: String,
    @SerialName("HTTPS")
    val https: Boolean,
    @SerialName("Cors")
    val cors: String,
    @SerialName("Link")
    val link: String,
    @SerialName("Category")
    val category: String,
)

@kotlinx.serialization.Serializable
data class Input(
    @SerialName("count")
    val count: Int,
    @SerialName("entries")
    val list: List<Entries>
)