package com.angelsoft.horoscapp.data.network.response

import com.angelsoft.horoscapp.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class PredictionResponseTest{
    @Test
    fun toDomainShouldReturnCorrectPredictionModel() {
        //Given
        val predictionResponse = anyResponse

        //When
        val predictionModel = predictionResponse.toDomain()

        //Then
        predictionModel.sign shouldBe predictionResponse.sign
        predictionModel.horoscope shouldBe predictionResponse.horoscope
    }
}