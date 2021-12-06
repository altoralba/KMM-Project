package com.aipaygo.kmmproj.Model.CoffeeModel

import kotlinx.serialization.Serializable

@Serializable
data class CoffeeModel(
    val blend_name: String,
    val id: Int,
    val intensifier: String,
    val notes: String,
    val origin: String,
    val uid: String,
    val variety: String
)