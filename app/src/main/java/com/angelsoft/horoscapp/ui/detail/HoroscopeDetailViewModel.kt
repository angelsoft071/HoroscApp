package com.angelsoft.horoscapp.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelsoft.horoscapp.domain.model.HoroscopeModel
import com.angelsoft.horoscapp.domain.model.PredictionModel
import com.angelsoft.horoscapp.domain.usecase.GetPrediction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPrediction: GetPrediction) :
    ViewModel() {

    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state
    lateinit var horoscope: HoroscopeModel

    fun getHoroscope(sign: HoroscopeModel) {
        horoscope = sign

        viewModelScope.launch() {
            _state.value = HoroscopeDetailState.Loading
            val result: PredictionModel? = withContext(Dispatchers.IO) { getPrediction(sign.name) }

            if (result == null) {
                _state.value =
                    HoroscopeDetailState.Error("Error getting prediction, tray again later.")
                return@launch
            }

            _state.value = HoroscopeDetailState.Success(result)
        }
    }
}