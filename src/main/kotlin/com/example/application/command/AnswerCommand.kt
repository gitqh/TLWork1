package com.example.application.command

data class AnswerCommand (
    val studentId: Long,
    val examId: Long,
    val questionId: Long
)