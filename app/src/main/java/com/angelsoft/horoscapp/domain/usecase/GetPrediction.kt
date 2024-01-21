package com.angelsoft.horoscapp.domain.usecase

import com.angelsoft.horoscapp.domain.Repository
import com.angelsoft.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class GetPrediction @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String): PredictionModel? = repository.getPrediction(sign)
}