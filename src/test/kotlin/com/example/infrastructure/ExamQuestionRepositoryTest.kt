package com.example.infrastructure

import com.example.domain.model.entity.QuestionAnswer
import com.example.infrastructure.mysql.repository.StudentExamAnswerMysqlRepository
import com.example.infrastructure.repository.ExamQuestionRepositoryImpl
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class ExamQuestionRepositoryTest(
        private val examQuestionRepositoryImpl: ExamQuestionRepositoryImpl,
        private val studentExamAnswerMysqlRepository: StudentExamAnswerMysqlRepository
) : StringSpec({
    "should save answer to db"{
        examQuestionRepositoryImpl.saveAnswerByExamIdQuestionId(QuestionAnswer(
                1, 1, ""
        ), 1, 1)
        val answer = studentExamAnswerMysqlRepository.findByExamIdAndQuestionId(1, 1)
        answer.size shouldBe 1
        answer.first().answer shouldBe 1
        answer.first().type shouldBe 1
        answer.first().answerText shouldBe ""
    }
})