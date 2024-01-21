package com.angelsoft.horoscapp.ui.detail

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import com.angelsoft.horoscapp.R
import com.angelsoft.horoscapp.databinding.ActivityHoroscopeDetailBinding
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Aquarius
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Aries
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Cancer
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Capricorn
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Gemini
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Leo
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Libra
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Pisces
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Sagittarius
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Scorpio
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Taurus
import com.angelsoft.horoscapp.domain.model.HoroscopeModel.Virgo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()
    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailViewModel.getHoroscope(args.type)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUiState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when (it) {
                        is HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        showProgressBar()
    }

    private fun errorState() {
        hideProgressBar()
    }

    private fun successState(state: HoroscopeDetailState.Success) {
        hideProgressBar()
        binding.tvTitle.text = state.prediction.sign
        binding.tvBody.text = state.prediction.horoscope

        val image = when (args.type) {
            Aries -> R.drawable.detail_aries
            Taurus -> R.drawable.detail_taurus
            Gemini -> R.drawable.detail_gemini
            Cancer -> R.drawable.detail_cancer
            Leo -> R.drawable.detail_leo
            Virgo -> R.drawable.detail_virgo
            Libra -> R.drawable.detail_libra
            Scorpio -> R.drawable.detail_scorpio
            Sagittarius -> R.drawable.detail_sagittarius
            Capricorn -> R.drawable.detail_capricorn
            Aquarius -> R.drawable.detail_aquarius
            Pisces -> R.drawable.detail_pisces
        }

        binding.ivDetail.setImageResource(image)
    }

    private fun showProgressBar() {
        binding.progressBar.isVisible = true
    }

    private fun hideProgressBar() {
        binding.progressBar.isVisible = false
    }
}