package com.aipaygo.kmmproj.Model.CucinaModel

import kotlinx.serialization.Serializable

@Serializable
data class Orders(
    val data: List<Data>
)