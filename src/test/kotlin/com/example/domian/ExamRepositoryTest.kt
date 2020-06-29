package com.example.domian

import com.example.domain.repository.ExamRepositoryImpl
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest(environments=["test"])
class ExamRepositoryTest(
        val examRepositoryImpl: ExamRepositoryImpl
) : StringSpec({
    "test"{

    }
})