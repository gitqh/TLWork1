package com.example.infrastructure

import com.example.infrastructure.repository.ExamRepositoryImpl
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest(environments=["test"])
class ExamRepositoryTest(
        val examRepositoryImpl: ExamRepositoryImpl
) : StringSpec({
    "test"{

    }
})