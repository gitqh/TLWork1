package com.example.infrastructure

import com.example.infrastructure.repository.StudentRepositoryImpl
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest(environments=["test"])
class StudentRepositoryTest(
        val studentRepositoryImpl: StudentRepositoryImpl
) : StringSpec({
    "test"{

    }
})