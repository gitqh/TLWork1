package com.example.representation.response

import com.example.domain.model.entity.Order

data class CreateOrderResponse(
        val id: Long,
        val goodId: Long,
        val type: String
)

fun Order.toResponse() = CreateOrderResponse(this.id, this.goodId, this.type)