package com.example.application

import com.example.application.client.PayClient
import com.example.application.client.PayInfo
import com.example.application.client.PayResult
import io.micronaut.context.annotation.Primary
import javax.inject.Singleton

@Singleton
@Primary
class PayClientStub : PayClient {
    override fun buy(payInfo: PayInfo): PayResult {
        if (payInfo.goodId >= 1000) {
            return PayResult(true)
        } else {
            return PayResult(false)
        }
    }
}