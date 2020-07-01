package com.example.application.stub

import com.example.domain.exception.ExamNotExistException
import com.example.domain.model.entity.Exam
import com.example.domain.repository.ExamRepository
import io.micronaut.context.annotation.Replaces
import java.util.Optional
import javax.inject.Singleton

@Singleton
@Replaces(ExamRepository::class)
class ExamRepositoryStub : ExamRepository {
    override fun findExamById(id: Long): Optional<Exam> {
        if (id == 1L) {
            throw ExamNotExistException()
        } else {
            return Optional.of(Exam(1))
        }
    }

}