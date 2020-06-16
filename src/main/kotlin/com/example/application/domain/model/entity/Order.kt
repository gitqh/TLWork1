package com.example.application.domain.model.entity

import com.example.infrastructure.repository.OrderRecord
import java.util.*

data class Order(
        var id: Long,
        var uid: Long,
        var goodId: Long,
        var type: String,
        var createTime: Date)

fun Order.toRecord() = OrderRecord(this.id, this.uid, this.goodId, this.type, this.createTime)

fun OrderRecord.toEntity() = Order(this.id!!, this.uid, this.goodId, this.type, this.createTime)