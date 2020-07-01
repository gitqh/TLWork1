package com.example.application

import com.example.application.command.AnswerCommand
import com.example.domain.exception.ExamIsEndException
import com.example.domain.exception.ExamNotExistException
import com.example.domain.exception.ExamNotStartException
import com.example.domain.exception.ExamStudentNotMatch
import com.example.domain.model.entity.QuestionAnswer
import com.example.domain.repository.ExamQuestionRepository
import com.example.domain.repository.ExamRepository
import java.time.LocalDateTime
import javax.inject.Singleton

@Singleton
class ExamService(
        private val examRepository: ExamRepository,
        private val examQuestionRepository: ExamQuestionRepository,
        val labelService: LabelService,
        val studentService: StudentService
) {
    fun answer(answerCommand: AnswerCommand) {
        val exam = examRepository.findExamById(answerCommand.examId)
        if (exam.isEmpty) throw ExamNotExistException()
        if (exam.get().exam.studentId != answerCommand.studentId) throw ExamStudentNotMatch()
        val now = LocalDateTime.now()
        if (now.isBefore(exam.get().plan.startTime)) throw ExamNotStartException()
        if (now.isAfter(exam.get().plan.endTime)) throw ExamIsEndException()
        examQuestionRepository.saveAnswerByExamIdQuestionId(QuestionAnswer(
                answerCommand.type,
                answerCommand.answer,
                answerCommand.answerText
        ), answerCommand.examId, answerCommand.questionId)
    }

    fun getAnswer(examId: Long, questionId: Long): QuestionAnswer? {
        return examQuestionRepository.getAnswerByExamIdQuestionId(examId, questionId)
    }
}