package com.example.domain.client

import io.micronaut.http.client.annotation.Client

@Client
interface MsgClient {
    fun send(msgRequest: MsgRequest): MsgResponse<Void>
}

data class MsgRequest(
        val uids: List<Long>,
        val msg: String
)

data class MsgResponse<T>(
        val code: Int,
        val message: Int,
        val data: T
)