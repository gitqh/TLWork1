package com.example.application

import com.example.application.client.PayClient
import com.example.application.client.PayInfo
import com.example.application.command.CreateOrderCommand
import com.example.domain.exception.OrderException
import com.example.domain.model.entity.Order
import com.example.domain.repository.OrderRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class OrderApplicationService(
        val payClient: PayClient,
        val orderRepository: OrderRepository
) {
    public fun order(createOrderCommand: CreateOrderCommand): Order {
        val payResult = payClient.buy(PayInfo(createOrderCommand.uid, createOrderCommand.goodId))
        if (payResult.success) {
            return orderRepository.saveOrder(Order(0, createOrderCommand.uid, createOrderCommand.goodId,
                    createOrderCommand.type, Date()))
        } else {
            throw OrderException()
        }
    }
}