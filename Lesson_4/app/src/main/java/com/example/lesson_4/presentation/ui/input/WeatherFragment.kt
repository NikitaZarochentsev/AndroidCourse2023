package com.example.lesson_4.presentation.ui.input

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.lesson_4.R
import com.example.lesson_4.databinding.FragmentWeatherBinding
import com.example.lesson_4.domain.MainViewModel

class WeatherFragment : Fragment() {

    private lateinit var binding: FragmentWeatherBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.weatherLiveData.observe(this as LifecycleOwner) {
            binding.textViewValueWeather.text = String.format(
                getString(R.string.text_view_value),
                it.city,
                it.temperature.toString()
            )
        }

        viewModel.errorMessage.observe(this as LifecycleOwner) {
            Toast.makeText(view.context, viewModel.errorMessage.value, Toast.LENGTH_SHORT).show()
        }

        binding.buttonWeather.setOnClickListener {
            showTemperature()
        }
        binding.textInputEditTextWeather.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                event.action == KeyEvent.ACTION_DOWN &&
                event.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                showTemperature()
                true
            } else {
                false
            }
        }
    }

    private fun showTemperature() {
        viewModel.setCity(binding.textInputEditTextWeather.text.toString())
    }
}