package com.example.domian

import com.example.domain.repository.ExamQuestionRepositoryImpl
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest(environments=["test"])
class ExamQuestionRepositoryTest(
        val examQuestionRepositoryImpl: ExamQuestionRepositoryImpl
) : StringSpec({
    "test"{

    }
})