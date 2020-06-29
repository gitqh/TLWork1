package com.example.application.stub

import com.example.domain.repository.StudentRepository
import io.micronaut.context.annotation.Replaces
import javax.inject.Singleton

@Singleton
@Replaces(StudentRepository::class)
class StudentRepositoryStub : StudentRepository {

}