package com.example.infrastructure

import com.example.infrastructure.mysql.repository.ExamMysqlRepository
import com.example.infrastructure.mysql.repository.ExamRecord
import com.example.infrastructure.repository.ExamRepositoryImpl
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class ExamRepositoryTest(
        val examRepository: ExamRepositoryImpl,
        val examMysqlRepository: ExamMysqlRepository
) : StringSpec({
    "examRepository find not exist exam id should be empty"{
        examMysqlRepository.save(ExamRecord(2, 1))
        examRepository.findExamById(1).isEmpty shouldBe true
    }
    "examRepository could find exam when exam id is exist"{
        examMysqlRepository.save(ExamRecord(1, 2))
        val exam = examRepository.findExamById(1)
        exam.isPresent shouldBe true
        exam.get().exam.id shouldBe 1
        exam.get().exam.studentId shouldBe 2
    }
})