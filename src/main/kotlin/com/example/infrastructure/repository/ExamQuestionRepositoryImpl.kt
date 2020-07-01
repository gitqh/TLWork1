package com.example.infrastructure.repository

import com.example.domain.model.entity.QuestionAnswer
import com.example.domain.repository.ExamQuestionRepository
import com.example.infrastructure.mysql.repository.ExamQuestionLabelMysqlRepository
import com.example.infrastructure.mysql.repository.ExamTemplateQuestionMysqlRepository
import com.example.infrastructure.mysql.repository.StudentExamAnswerMysqlRepository
import com.example.infrastructure.mysql.repository.StudentExamAnswerRecord
import com.example.infrastructure.utils.UidUtil
import javax.inject.Singleton

@Singleton
class ExamQuestionRepositoryImpl(
        val examQuestionLabelMysqlRepository: ExamQuestionLabelMysqlRepository,
        val examTemplateQuestionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        val questionMysqlRepository: ExamTemplateQuestionMysqlRepository,
        private val studentExamAnswerMysqlRepository: StudentExamAnswerMysqlRepository
) : ExamQuestionRepository {
    override fun saveAnswerByExamIdQuestionId(questionAnswer: QuestionAnswer, examId: Long, questionId: Long) {
        val find = studentExamAnswerMysqlRepository.findByExamIdAndQuestionId(examId, questionId)
        val studentExamAnswerRecord = StudentExamAnswerRecord(UidUtil.instance.nextId(),
                examId,
                questionId,
                questionAnswer.type,
                questionAnswer.answer,
                questionAnswer.answerText
        )
        if (find.isEmpty()) {
            studentExamAnswerMysqlRepository.save(studentExamAnswerRecord)
        } else {
            studentExamAnswerRecord.id = find.first().id
            studentExamAnswerMysqlRepository.update(studentExamAnswerRecord)
        }
    }

    override fun getAnswerByExamIdQuestionId(examId: Long, questionId: Long): QuestionAnswer? {
        return studentExamAnswerMysqlRepository.findByExamIdAndQuestionId(examId, questionId).map {
            QuestionAnswer(it.type, it.answer, it.answerText)
        }.firstOrNull()
    }
}