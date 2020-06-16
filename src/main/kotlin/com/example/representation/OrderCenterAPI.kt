package com.example.representation

import com.example.application.OrderApplicationService
import com.example.representation.request.CreateOrderRequest
import com.example.representation.request.toCommand
import com.example.representation.response.toResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post

@Controller
class OrderCenterAPI(
        val orderApplicationService: OrderApplicationService
) {
    @Post("/create-order")
    fun createOrder(
            @Header("uid") uid: Long,
            @Body createOrderRequest: CreateOrderRequest
    ) = orderApplicationService.order(createOrderRequest.toCommand(uid)).toResponse()
}