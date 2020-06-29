package com.example.application

import com.example.domain.repository.StudentRepository
import javax.inject.Singleton

@Singleton
class StudentService(
        val studentRepository: StudentRepository
) {

}