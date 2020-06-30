package com.example.domian

import com.example.infrastructure.repository.LabelRepositoryImpl
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest(environments=["test"])
class LabelRepositoryTest(
        val labelRepositoryImpl: LabelRepositoryImpl
) : StringSpec({
    "test"{

    }
})