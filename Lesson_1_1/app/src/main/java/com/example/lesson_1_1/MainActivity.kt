package com.example.lesson_1_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_1_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToRedActivity.setOnClickListener {
            val intent = Intent(this, RedActivity::class.java)
            startActivity(intent)
        }

        binding.buttonToGreenActivity.setOnClickListener {
            val intent = Intent(this, GreenActivity::class.java)
            startActivity(intent)
        }

        binding.buttonToBlueActivity.setOnClickListener {
            val intent = Intent(this, BlueActivity::class.java)
            startActivity(intent)
        }
    }
}