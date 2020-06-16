package com.example.infrastructure.repository

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.CrudRepository
import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Repository
@JdbcRepository(dialect = Dialect.H2)
interface OrderH2Repository : CrudRepository<OrderRecord, Long> {

}

@Entity
data class OrderRecord(
        @Id
        @GeneratedValue
        var id: Long,
        var uid: Long,
        var goodId: Long,
        var type: String,
        var createTime: Date)