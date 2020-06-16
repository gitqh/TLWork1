package com.example.infrastructure.repository

import com.example.domain.exception.OrderTypeException
import com.example.domain.model.entity.Order
import com.example.domain.repository.OrderRepository
import javax.inject.Singleton

@Singleton
class OrderRepositoryImpl(
        val orderH2Repository: OrderH2Repository,
        val orderTypeH2Repository: OrderTypeH2Repository
) : OrderRepository {
    override fun saveOrder(order: Order): Order {
        if (orderTypeH2Repository.findByType(order.type).isEmpty()) {
            throw OrderTypeException()
        }
        return orderH2Repository.save(order.toRecord()).toEntity()
    }
}