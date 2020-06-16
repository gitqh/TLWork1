package com.example.infrastructure.repository

import com.example.application.domain.model.entity.Order

interface OrderRepository {
    fun saveOrder(order: Order): Order
}