package com.example.domain.repository

import com.example.infrastructure.repository.*
import javax.inject.Singleton

@Singleton
class StudentRepositoryImpl(
        val classMysqlRepository: ClassMysqlRepository,
        val studentMysqlRepository: StudentMysqlRepository
) : StudentRepository {

}