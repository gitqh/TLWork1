package com.example.domain.model.entity

import java.util.*

data class Order(
        var id: Long,
        var uid: Long,
        var goodId: Long,
        var type: String,
        var createTime: Date)