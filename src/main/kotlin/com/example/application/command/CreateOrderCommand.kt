package com.example.application.command

import com.example.representation.request.CreateOrderRequest

data class CreateOrderCommand(
        val uid: Long,
        val goodId: Long,
        val type: String
)

fun CreateOrderRequest.toCommand(uid: Long): CreateOrderCommand {
    return CreateOrderCommand(uid, this.goodId, this.type)
}