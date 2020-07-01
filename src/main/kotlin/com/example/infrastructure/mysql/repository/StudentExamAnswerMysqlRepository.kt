package com.example.infrastructure.mysql.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import javax.persistence.Entity
import javax.persistence.Id

@Repository
@JdbcRepository(dialect = Dialect.H2)
interface StudentExamAnswerMysqlRepository : CrudRepository<StudentExamAnswerRecord, Long> {
    fun findByExamIdAndQuestionId(examId: Long, questionId: Long): List<StudentExamAnswerRecord>
}

@Entity
data class StudentExamAnswerRecord(
        @Id
        var id: Long,
        var examId: Long,
        var questionId: Long,
        var type: Int,
        var answer: Int,
        var answerText: String
)