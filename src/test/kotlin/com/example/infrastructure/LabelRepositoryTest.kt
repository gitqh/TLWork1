package com.example.infrastructure

import com.example.infrastructure.repository.LabelRepositoryImpl
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class LabelRepositoryTest(
        val labelRepositoryImpl: LabelRepositoryImpl
) : StringSpec({
    "test"{

    }
})