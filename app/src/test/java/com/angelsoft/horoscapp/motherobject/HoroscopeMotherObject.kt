package com.angelsoft.horoscapp.motherobject

import com.angelsoft.horoscapp.data.network.response.PredictionResponse
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

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf(
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