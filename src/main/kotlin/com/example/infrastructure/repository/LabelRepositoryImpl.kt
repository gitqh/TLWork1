package com.example.infrastructure.repository

import com.example.domain.repository.LabelRepository
import com.example.infrastructure.mysql.repository.LabelMysqlRepository
import javax.inject.Singleton

@Singleton
class LabelRepositoryImpl(
        val labelMysqlRepository: LabelMysqlRepository
) : LabelRepository {

}