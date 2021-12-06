package com.aipaygo.kmmproj.Model.CucinaModel

import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable

@Serializable
data class Order(
    val cart_id: String,
    val created_at: String,
    val dish_id: String,
    val id: Int,
    val name: String,
    val `package`: String,
    val price: String,
    val quantity: String,
    val updated_at: String
)