package com.example.infrastructure

import com.example.infrastructure.mysql.repository.*
import com.example.infrastructure.repository.ExamRepositoryImpl
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest
import java.time.LocalDateTime

@MicronautTest
class ExamRepositoryTest(
        private val examRepository: ExamRepositoryImpl,
        private val examMysqlRepository: ExamMysqlRepository,
        private val examPlanMysqlRepository: ExamPlanMysqlRepository,
        private val examTemplateMysqlRepository: ExamTemplateMysqlRepository
) : StringSpec({
    "examRepository find not exist exam id should be empty"{
        examMysqlRepository.save(ExamRecord(2, 1, 1))
        examRepository.findExamById(1).isEmpty shouldBe true
    }
    "examRepository could find exam when exam id is exist"{
        examMysqlRepository.save(ExamRecord(1, 2, 1))
        examPlanMysqlRepository.save(ExamPlanRecord(1, 1, 1, LocalDateTime.now(), LocalDateTime.now()))
        examTemplateMysqlRepository.save(ExamTemplateRecord(1, "test", 1))
        val exam = examRepository.findExamById(1)
        exam.isPresent shouldBe true
        exam.get().exam.id shouldBe 1
        exam.get().exam.studentId shouldBe 2
    }
    "examRepository could find exam and has plan"{
        examMysqlRepository.save(ExamRecord(1, 2, 1))
        val endTime = LocalDateTime.now()
        val startTime = LocalDateTime.now().plusHours(1)
        examPlanMysqlRepository.save(ExamPlanRecord(1, 1, 1, startTime, endTime))
        examTemplateMysqlRepository.save(ExamTemplateRecord(1, "test", 1))
        val exam = examRepository.findExamById(1)
        exam.isPresent shouldBe true
        exam.get().plan.endTime.minute shouldBe endTime.minute
        exam.get().plan.startTime.minute shouldBe startTime.minute
    }
})