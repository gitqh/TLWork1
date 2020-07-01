package com.example.infrastructure.repository

import com.example.domain.model.entity.QuestionAnswer
import com.example.domain.repository.ExamQuestionRepository
import com.example.infrastructure.mysql.repository.ExamQuestionLabelMysqlRepository
import com.example.infrastructure.mysql.repository.ExamTemplateQuestionMysqlRepository
import com.example.infrastructure.mysql.repository.StudentExamAnswerMysqlRepository
import com.example.infrastructure.mysql.repository.StudentExamAnswerRecord
import javax.inject.Singleton

@Singleton
class ExamQuestionRepositoryImpl(
        val examQuestionLabelMysqlRepository: ExamQuestionLabelMysqlRepository,
        val examTemplateQuestionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        val questionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        private val studentExamAnswerMysqlRepository: StudentExamAnswerMysqlRepository
) : ExamQuestionRepository {
    override fun saveAnswerByExamIdQuestionId(questionAnswer: QuestionAnswer, examId: Long, questionId: Long) {
        studentExamAnswerMysqlRepository.save(StudentExamAnswerRecord(1,
                examId,
                questionId,
                questionAnswer.type,
                questionAnswer.answer,
                questionAnswer.answerText
        ))
    }
}