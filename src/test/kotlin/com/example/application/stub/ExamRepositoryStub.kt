package com.example.application.stub

import com.example.domain.repository.ExamRepository
import io.micronaut.context.annotation.Replaces
import javax.inject.Singleton

@Singleton
@Replaces(ExamRepository::class)
class ExamRepositoryStub : ExamRepository {

}