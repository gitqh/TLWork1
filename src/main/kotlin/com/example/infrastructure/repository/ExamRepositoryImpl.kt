package com.example.infrastructure.repository

import com.example.domain.model.entity.Exam
import com.example.domain.model.entity.ExamInfo
import com.example.domain.repository.ExamRepository
import com.example.infrastructure.mysql.repository.ExamMysqlRepository
import com.example.infrastructure.mysql.repository.ExamPlanMysqlRepository
import com.example.infrastructure.mysql.repository.ExamTemplateMysqlRepository
import java.util.Optional
import javax.inject.Singleton

@Singleton
class ExamRepositoryImpl(
        val examMysqlRepository: ExamMysqlRepository,
        val examPlanMysqlRepository: ExamPlanMysqlRepository,
        val examTemplateMysqlRepository: ExamTemplateMysqlRepository
) : ExamRepository {
    override fun findExamById(id: Long): Optional<Exam> {
        return examMysqlRepository.findById(id).map {
            Exam(ExamInfo(it.id, it.studentId), emptyList())
        }
    }

}