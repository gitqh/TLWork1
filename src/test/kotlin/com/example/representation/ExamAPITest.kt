package com.example.representation

import com.example.application.ExamService
import com.example.representation.response.Response
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.kotlintest.MicronautKotlinTestExtension.getMock
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk

@MicronautTest
class ExamAPITest(
        val examService: ExamService,
        @Client("/") private val client: HttpClient
) : StringSpec({
    "test answer api" {
        val examServiceStub = getMock(examService)
        every { examServiceStub.answer(any()) } just Runs
        val body = """
            {
                "type":1,
                "answer":1,
                "answerText":""
            }
        """.trimIndent()
        val retrieve = client.toBlocking().retrieve(HttpRequest.PUT("/exams/1/questions/1/answer", body), Response::class.java)
        retrieve.code shouldBe 0
    }
}) {
    @MockBean(ExamService::class)
    fun examService(): ExamService {
        return mockk()
    }
}