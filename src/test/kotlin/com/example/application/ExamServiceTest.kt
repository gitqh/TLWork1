package com.example.application

import com.example.application.command.AnswerCommand
import com.example.domain.exception.ExamIsEndException
import com.example.domain.exception.ExamNotExistException
import com.example.domain.exception.ExamNotStartException
import com.example.domain.exception.ExamStudentNotMatch
import com.example.domain.model.entity.Exam
import com.example.domain.model.entity.ExamInfo
import com.example.domain.model.entity.ExamPlan
import com.example.domain.model.entity.ExamTemplate
import com.example.domain.repository.ExamRepository
import io.kotlintest.shouldBe
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotlintest.MicronautKotlinTestExtension.getMock
import io.mockk.every
import io.mockk.mockk
import java.time.LocalDateTime
import java.util.Optional

@MicronautTest
class ExamServiceTest(
        private val examService: ExamService,
        private val examRepository: ExamRepository
) : StringSpec({

    "i can't commit answer when exam is not exist"{
        val examRepositoryStub = getMock(examRepository)
        every { examRepositoryStub.findExamById(1) } returns Optional.empty()
        shouldThrow<ExamNotExistException> {
            examService.answer(AnswerCommand(1, 1, 1, 1, 1, ""))
        }
    }

    "i can't commit answer when exam is not mine"{
        val examRepositoryStub = getMock(examRepository)
        every { examRepositoryStub.findExamById(1) } returns
                Optional.of(Exam(exam = ExamInfo(1, 2),
                        examTemplate = ExamTemplate(1, "test", 1),
                        plan = ExamPlan(LocalDateTime.now(), LocalDateTime.now())))
        shouldThrow<ExamStudentNotMatch> {
            examService.answer(AnswerCommand(1, 1, 1, 1, 1, ""))
        }
    }

    "i can't commit answer when exam is not start"{
        val examRepositoryStub = getMock(examRepository)
        every { examRepositoryStub.findExamById(1) } returns
                Optional.of(Exam(exam = ExamInfo(1, 1),
                        examTemplate = ExamTemplate(1, "test", 1),
                        plan = ExamPlan(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2))))
        shouldThrow<ExamNotStartException> {
            examService.answer(AnswerCommand(1, 1, 1, 1, 1, ""))
        }
    }

    "i can't commit answer when exam is ended"{
        val examRepositoryStub = getMock(examRepository)
        every { examRepositoryStub.findExamById(1) } returns
                Optional.of(Exam(exam = ExamInfo(1, 1),
                        examTemplate = ExamTemplate(1, "test", 1),
                        plan = ExamPlan(LocalDateTime.now().minusHours(2), LocalDateTime.now().minusHours(2))))
        shouldThrow<ExamIsEndException> {
            examService.answer(AnswerCommand(1, 1, 1, 1, 1, ""))
        }
    }

    "i can commit answer"{
        val examRepositoryStub = getMock(examRepository)
        every { examRepositoryStub.findExamById(1) } returns
                Optional.of(Exam(exam = ExamInfo(1, 1),
                        examTemplate = ExamTemplate(1, "test", 1),
                        plan = ExamPlan(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1))))
        examService.answer(AnswerCommand(1, 1, 1, 1, 1, ""))
    }

    "i can commit answer same question more times"{
        val examRepositoryStub = getMock(examRepository)
        every { examRepositoryStub.findExamById(1) } returns
                Optional.of(Exam(exam = ExamInfo(1, 1),
                        examTemplate = ExamTemplate(1, "test", 1),
                        plan = ExamPlan(LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(1))))
        examService.answer(AnswerCommand(1, 1, 1, 1, 1, "one"))
        examService.answer(AnswerCommand(1, 1, 1, 1, 1, "two"))
        examService.getAnswer(1, 1)!!.answerText shouldBe "two"

    }
}) {
    @MockBean(ExamRepository::class)
    fun examRepository(): ExamRepository {
        return mockk()
    }
}