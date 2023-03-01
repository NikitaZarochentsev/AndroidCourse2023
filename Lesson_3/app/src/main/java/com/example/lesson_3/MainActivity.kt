package com.example.lesson_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import androidx.fragment.app.commit
import com.example.lesson_3.databinding.ActivityMainBinding
import com.example.lesson_3.presentation.ui.signin.SignInFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fitContentViewToInsets()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.containerMain, SignInFragment())
        }
    }

    private fun fitContentViewToInsets() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
}