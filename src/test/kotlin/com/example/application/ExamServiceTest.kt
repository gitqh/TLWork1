package com.example.application

import com.example.application.command.AnswerCommand
import com.example.domain.exception.ExamNotExistException
import com.example.domain.exception.ExamStudentNotMatch
import com.example.domain.model.entity.Exam
import com.example.domain.model.entity.ExamInfo
import com.example.domain.model.entity.QuestionInfo
import com.example.domain.repository.ExamRepository
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotlintest.MicronautKotlinTestExtension.getMock
import io.mockk.every
import io.mockk.mockk
import java.util.Optional

@MicronautTest
class ExamServiceTest(
        val examService: ExamService,
        val examRepository: ExamRepository
) : StringSpec({

    val examRepositoryStub = getMock(examRepository)

    "i can't commit answer when exam is not exist"{
        every { examRepositoryStub.findExamById(1) } returns Optional.empty()
        shouldThrow<ExamNotExistException> {
            examService.answer(AnswerCommand(1, 1, 1))
        }
    }

    "i can't commit answer when exam is not mine"{
        every { examRepositoryStub.findExamById(1) } returns
                Optional.of(Exam(exam = ExamInfo(1, 2), questions = listOf(QuestionInfo(1))))
        shouldThrow<ExamStudentNotMatch> {
            examService.answer(AnswerCommand(1, 1, 1))
        }
    }
}) {
    @MockBean(ExamRepository::class)
    fun examRepository(): ExamRepository {
        return mockk()
    }
}