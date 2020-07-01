package com.example.representation

import com.example.application.ExamService
import com.example.application.command.AnswerCommand
import com.example.representation.response.Response
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Put

@Controller("exams")
class ExamAPI(
        val examService: ExamService
) {
    @Put("/{examId}/questions/{questionId}/answer")
    fun answer(@PathVariable examId: Long, @PathVariable questionId: Long): Response<Void> {
        examService.answer(AnswerCommand(1, examId, questionId))
        return Response(0, "OK", null)
    }

}