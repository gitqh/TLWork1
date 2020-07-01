package com.example.representation.request

data class AnswerRequest(
        val type: Int,
        val answer: Int,
        val answerText: String
)