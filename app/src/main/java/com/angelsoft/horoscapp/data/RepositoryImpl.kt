package com.angelsoft.horoscapp.data

import android.util.Log
import com.angelsoft.horoscapp.data.network.HoroscopeApiService
import com.angelsoft.horoscapp.domain.Repository
import com.angelsoft.horoscapp.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImpl @Inject constructor(private val apiService: HoroscopeApiService) : Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching { apiService.getHoroscope(sign) }
            .onSuccess { return it.toDomain() }
            .onFailure { Log.i("Error", "Error: ${it.message}") }

        return null
    }
}