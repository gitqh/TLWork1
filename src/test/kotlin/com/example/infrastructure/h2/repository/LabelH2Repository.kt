package com.example.infrastructure.h2.repository

import com.example.infrastructure.mysql.repository.LabelMysqlRepository
import io.micronaut.context.annotation.Replaces
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect

@Repository
@JdbcRepository(dialect = Dialect.H2)
@Replaces(LabelMysqlRepository::class)
interface LabelH2Repository : LabelMysqlRepository
