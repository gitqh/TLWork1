package com.example.infrastructure.mysql.repository

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Repository
@JdbcRepository(dialect = Dialect.MYSQL)
interface ExamPlanMysqlRepository : CrudRepository<ExamPlanRecord, Long> {
    fun findByExamId(examId: Long): List<ExamPlanRecord>
}

@Entity
data class ExamPlanRecord(
        @Id
        var id: Long,
        var examId: Long,
        var studentId: Long,
        var startTime: LocalDateTime,
        var endTime: LocalDateTime
)