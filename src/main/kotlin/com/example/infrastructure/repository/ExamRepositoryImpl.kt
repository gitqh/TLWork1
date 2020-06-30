package com.example.infrastructure.repository

import com.example.domain.repository.ExamRepository
import com.example.infrastructure.mysql.repository.ExamMysqlRepository
import com.example.infrastructure.mysql.repository.ExamPlanMysqlRepository
import com.example.infrastructure.mysql.repository.ExamTemplateMysqlRepository
import javax.inject.Singleton

@Singleton
class ExamRepositoryImpl(
        val examMysqlRepository: ExamMysqlRepository,
        val examPlanMysqlRepository: ExamPlanMysqlRepository,
        val examTemplateMysqlRepository: ExamTemplateMysqlRepository
) : ExamRepository {

}