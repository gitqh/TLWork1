package com.example.domain.repository

import com.example.infrastructure.repository.*
import javax.inject.Singleton

@Singleton
class ExamQuestionRepositoryImpl(
        val examQuestionLabelMysqlRepository: ExamQuestionLabelMysqlRepository,
        val examTemplateQuestionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        val questionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        val studentExamAnswerMysqlRepository: StudentExamAnswerMysqlRepository
) : ExamQuestionRepository {

}