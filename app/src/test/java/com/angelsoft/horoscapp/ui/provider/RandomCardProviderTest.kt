package com.angelsoft.horoscapp.ui.provider

import org.junit.Test
import org.junit.Assert.*

class RandomCardProviderTest{
    @Test
    fun getLuckyShouldReturnRandomCard() {
        val randomCardProvider = RandomCardProvider()

        val card = randomCardProvider.getLucky()

        assertNotNull(card)
    }
}