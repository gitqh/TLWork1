package com.example.application.client

import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client

@Client
interface PayClient {
    @Post("/pay")
    fun buy(payInfo: PayInfo): PayResult
}

data class PayInfo(
        val uid: Long,
        val goodId: Long
)

data class PayResult(
        val success: Boolean
)