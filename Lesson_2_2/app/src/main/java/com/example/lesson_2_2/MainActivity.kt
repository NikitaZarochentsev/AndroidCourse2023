package com.example.lesson_2_2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.lesson_2_2.databinding.ActivityMainBinding
import com.example.lesson_2_2.fragments.FirstFragment
import com.example.lesson_2_2.fragments.SecondFragment
import com.example.lesson_2_2.fragments.ThirdFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1Main.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewMain, FirstFragment())
                addToBackStack(null)
            }
        }

        binding.button2Main.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewMain, SecondFragment())
                addToBackStack(null)
            }
        }

        binding.button3Main.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewMain, ThirdFragment())
                addToBackStack(null)
            }
        }
    }
}