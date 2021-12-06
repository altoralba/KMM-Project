package com.aipaygo.kmmproj.Model.CucinaModel

import kotlinx.serialization.Serializable

@Serializable
data class Data(
    val id: Int,
    val order_id: String = "",
    val status: String = "",
    val orders: List<Order>,
    val order_type: String,
    val payment_type: String,
    val destination: String,
    val name: String,
    val phone_number: String,
    val created_at: String
)