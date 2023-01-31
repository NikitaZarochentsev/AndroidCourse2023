package com.example.lesson_1_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lesson_1_3.databinding.ActivityHelloBinding

class HelloActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHelloBinding

    companion object {
        const val NAME_EXTRAS = "name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHelloBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = getString(
            R.string.text_view_hello, intent.getStringExtra(NAME_EXTRAS).toString()
        )
    }
}