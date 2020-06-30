package com.example.infrastructure.repository

import com.example.domain.repository.ExamQuestionRepository
import com.example.infrastructure.mysql.repository.ExamQuestionLabelMysqlRepository
import com.example.infrastructure.mysql.repository.ExamTemplateQuestionMysqlRepository
import com.example.infrastructure.mysql.repository.StudentExamAnswerMysqlRepository
import javax.inject.Singleton

@Singleton
class ExamQuestionRepositoryImpl(
        val examQuestionLabelMysqlRepository: ExamQuestionLabelMysqlRepository,
        val examTemplateQuestionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        val questionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        val studentExamAnswerMysqlRepository: StudentExamAnswerMysqlRepository
) : ExamQuestionRepository {

}