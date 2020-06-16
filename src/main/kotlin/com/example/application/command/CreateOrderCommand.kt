package com.example.application.command

data class CreateOrderCommand(
        val uid: Long,
        val goodId: Long,
        val type: String
)