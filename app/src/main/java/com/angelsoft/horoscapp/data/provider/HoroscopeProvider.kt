package com.angelsoft.horoscapp.data.provider

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
import javax.inject.Inject

class HoroscopeProvider @Inject constructor() {
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
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