package com.example.representation.response

data class Response<T>(
        val code: Int,
        val msg: String,
        val data: T
)