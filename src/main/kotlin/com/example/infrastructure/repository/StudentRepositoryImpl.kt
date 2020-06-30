package com.example.infrastructure.repository

import com.example.domain.repository.StudentRepository
import com.example.infrastructure.mysql.repository.ClassMysqlRepository
import com.example.infrastructure.mysql.repository.StudentMysqlRepository
import javax.inject.Singleton

@Singleton
class StudentRepositoryImpl(
        val classMysqlRepository: ClassMysqlRepository,
        val studentMysqlRepository: StudentMysqlRepository
) : StudentRepository {

}