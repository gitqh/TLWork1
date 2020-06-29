package com.example.application

import com.example.domain.repository.LabelRepository
import javax.inject.Singleton

@Singleton
class LabelService(
        val labelRepository: LabelRepository
) {

}