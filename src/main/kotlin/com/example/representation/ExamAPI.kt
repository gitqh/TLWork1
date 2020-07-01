package com.example.representation

import com.example.application.ExamService
import com.example.application.command.AnswerCommand
import com.example.representation.request.AnswerRequest
import com.example.representation.response.Response
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put

@Controller("exams")
class ExamAPI(
        private val examService: ExamService
) {
    @Put("/{examId}/questions/{questionId}/answer")
    fun answer(@PathVariable examId: Long, @PathVariable questionId: Long, @Body answerRequest: AnswerRequest): Response<Void> {
        examService.answer(AnswerCommand(
                1,
                examId,
                questionId,
                answerRequest.type,
                answerRequest.answer,
                answerRequest.answerText))
        return Response(0, "OK", null)
    }

}