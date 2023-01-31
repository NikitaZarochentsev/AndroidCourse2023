package com.example.lesson_1_2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.lesson_1_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToBrowser.setOnClickListener {
            var address = binding.editText.text.toString()
            if (!address.startsWith("https:")){
                address = "https:$address"
            }
            val addressUri = Uri.parse(address)
            val intent = Intent(Intent.ACTION_VIEW, addressUri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.app_missing), Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonToEmail.setOnClickListener {
            val emailUri = Uri.parse("mailto:${binding.editText.text}")
            val intent = Intent(Intent.ACTION_VIEW, emailUri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.app_missing), Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonToPhone.setOnClickListener {
            val phoneNumberUri = Uri.parse("tel:${binding.editText.text}")
            val intent = Intent(Intent.ACTION_VIEW, phoneNumberUri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.app_missing), Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonToMap.setOnClickListener {
            val coordinatesUri = Uri.parse("geo:${binding.editText.text}")
            val intent = Intent(Intent.ACTION_VIEW, coordinatesUri)
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.app_missing), Toast.LENGTH_SHORT).show()
            }
        }
    }
}