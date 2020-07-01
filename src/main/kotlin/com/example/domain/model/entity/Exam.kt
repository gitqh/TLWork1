package com.example.domain.model.entity

import java.time.LocalDateTime

data class Exam(
        var exam: ExamInfo,
        var examTemplate: ExamTemplate,
        var plan: ExamPlan
)

data class ExamInfo(
        var id: Long,
        var studentId: Long
)

data class ExamTemplate(
        var id: Long,
        var name: String,
        var type: Int
)

data class ExamPlan(
        var startTime: LocalDateTime,
        var endTime: LocalDateTime
)