package com.example.representation.request

import com.example.application.command.CreateOrderCommand

data class CreateOrderRequest(
        val goodId: Long,
        val type: String
)
fun CreateOrderRequest.toCommand(uid: Long): CreateOrderCommand {
    return CreateOrderCommand(uid, this.goodId, this.type)
}