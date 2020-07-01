package com.example.application

import com.example.application.command.AnswerCommand
import com.example.domain.exception.ExamNotExistException
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec

class ExamServiceTest(
        val examService: ExamService
) : StringSpec({
    "i can't commit answer when exam is not exist"{
        shouldThrow<ExamNotExistException> {
            examService.answer(1,1, AnswerCommand())
        }
    }
})