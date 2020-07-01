package com.example.domain.model.entity

data class Exam(
        val exam: ExamInfo,
        val questions: List<QuestionInfo>
)

data class ExamInfo(
        val id: Long,
        val studentId: Long
)

data class QuestionInfo(
        val id: Long
)