package com.example.representation.request

data class CreateOrderRequest(
        val goodId: Long,
        val type: String
)