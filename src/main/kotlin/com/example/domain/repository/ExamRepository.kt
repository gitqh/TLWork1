package com.example.domain.repository

import com.example.domain.model.entity.Exam
import java.util.Optional

interface ExamRepository {
    fun findExamById(id: Long): Optional<Exam>
}