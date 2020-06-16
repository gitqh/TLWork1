package com.example.domain.repository

import com.example.domain.model.entity.Order

interface OrderRepository {
    fun saveOrder(order: Order): Order
}