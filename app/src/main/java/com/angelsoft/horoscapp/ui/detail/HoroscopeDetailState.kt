package com.angelsoft.horoscapp.ui.detail

import com.angelsoft.horoscapp.domain.model.PredictionModel

sealed class HoroscopeDetailState {
    data object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val prediction: PredictionModel) : HoroscopeDetailState()
}