package com.example.domain.repository

import com.example.infrastructure.repository.LabelMysqlRepository
import javax.inject.Singleton

@Singleton
class LabelRepositoryImpl(
        val labelMysqlRepository: LabelMysqlRepository
) : LabelRepository {

}