package com.example.representation

import com.example.application.ExamService
import io.micronaut.http.annotation.Controller

@Controller
class ExamAPI(
        val examService: ExamService
) {
}