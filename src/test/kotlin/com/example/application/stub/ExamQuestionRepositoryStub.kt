package com.example.application.stub

import com.example.domain.repository.ExamQuestionRepository
import io.micronaut.context.annotation.Replaces
import javax.inject.Singleton

@Singleton
@Replaces(ExamQuestionRepository::class)
class ExamQuestionRepositoryStub : ExamQuestionRepository {

}