package com.angelsoft.horoscapp.ui.horoscope

import androidx.lifecycle.ViewModel
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Aquarius
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Aries
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Cancer
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Capricorn
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Gemini
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Leo
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Libra
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Pisces
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Sagittarius
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Scorpio
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Taurus
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo.Virgo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor() : ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        _horoscope.value = listOf(
            Aries,
            Taurus,
            Gemini,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagittarius,
            Capricorn,
            Aquarius,
            Pisces
        )
    }
}