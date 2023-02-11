package com.example.lesson_2_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.lesson_2_3.databinding.ActivityMainBinding
import com.example.lesson_2_3.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAMain.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewCharMain, AFragment())
                addToBackStack(null)
            }
        }

        binding.buttonBMain.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewCharMain, BFragment())
                addToBackStack(null)
            }
        }

        binding.buttonCMain.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewCharMain, CFragment())
                addToBackStack(null)
            }
        }

        binding.button1Main.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewNumberMain, FirstFragment())
                addToBackStack(null)
            }
        }

        binding.button2Main.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewNumberMain, SecondFragment())
                addToBackStack(null)
            }
        }

        binding.button3Main.setOnClickListener {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                replace(R.id.fragmentContainerViewNumberMain, ThirdFragment())
                addToBackStack(null)
            }
        }
    }
}