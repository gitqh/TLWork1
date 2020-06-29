package com.example.application.stub

import com.example.domain.repository.LabelRepository
import io.micronaut.context.annotation.Replaces
import javax.inject.Singleton

@Singleton
@Replaces(LabelRepository::class)
class LabelRepositoryStub : LabelRepository {

}