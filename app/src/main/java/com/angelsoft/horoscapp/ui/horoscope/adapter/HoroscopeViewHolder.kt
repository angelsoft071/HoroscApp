package com.angelsoft.horoscapp.ui.horoscope.adapter

import android.view.View
import android.view.animation.AccelerateInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.angelsoft.horoscapp.databinding.ItemHoroscopeBinding
import com.angelsoft.horoscapp.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)
    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = binding.ivHoroscope.context
        binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        binding.tvHoroscopeTitle.text = context.getString(horoscopeInfo.name)
        binding.parent.setOnClickListener {
            startRotation(binding.ivHoroscope, callback = { onItemSelected(horoscopeInfo) })
        }
    }

    private fun startRotation(view: View, callback: () -> Unit) {
        view.animate().apply {
            duration = 300
            interpolator = AccelerateInterpolator()
            rotationBy(360f)
            withEndAction { callback() }
            start()
        }
    }
}