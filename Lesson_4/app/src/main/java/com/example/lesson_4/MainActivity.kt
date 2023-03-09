package com.example.lesson_4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.fragment.app.commit
import com.example.lesson_4.databinding.ActivityMainBinding
import com.example.lesson_4.presentation.ui.input.WeatherFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        supportFragmentManager.commit {
            replace(R.id.fragmentContainerViewMain, WeatherFragment())
        }
    }
}