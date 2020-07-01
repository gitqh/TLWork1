package com.example.application

import com.example.application.command.AnswerCommand
import com.example.domain.exception.ExamNotExistException
import com.example.domain.exception.ExamStudentNotMatch
import com.example.domain.repository.ExamQuestionRepository
import com.example.domain.repository.ExamRepository
import javax.inject.Singleton

@Singleton
class ExamService(
        val examRepository: ExamRepository,
        val examQuestionRepository: ExamQuestionRepository,
        val labelService: LabelService,
        val studentService: StudentService
) {
    fun answer(answerCommand: AnswerCommand) {
        val exam = examRepository.findExamById(answerCommand.examId)
        if (exam.isEmpty) throw ExamNotExistException()
        if (exam.get().exam.studentId != answerCommand.studentId) throw ExamStudentNotMatch()
    }
}