package com.example.domian

import com.example.domain.repository.StudentRepositoryImpl
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest(environments=["test"])
class StudentRepositoryTest(
        val studentRepositoryImpl: StudentRepositoryImpl
) : StringSpec({
    "test"{

    }
})