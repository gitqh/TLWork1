package com.example.domain.repository

import com.example.domain.model.entity.QuestionAnswer

interface ExamQuestionRepository {
    fun saveAnswerByExamIdQuestionId(questionAnswer: QuestionAnswer, examId: Long, questionId: Long)
}