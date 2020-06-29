package com.example.domain.repository

import com.example.infrastructure.repository.*
import javax.inject.Singleton

@Singleton
class ExamRepositoryImpl(
        val examMysqlRepository: ExamMysqlRepository,
        val examPlanMysqlRepository: ExamPlanMysqlRepository,
        val examTemplateMysqlRepository: ExamTemplateMysqlRepository
) : ExamRepository {

}