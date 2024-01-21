package com.angelsoft.horoscapp.domain

import com.angelsoft.horoscapp.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}