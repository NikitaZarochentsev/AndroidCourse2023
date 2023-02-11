package com.example.lesson_2_4

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.Lifecycle
import com.example.lesson_2_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val logList = ArrayList<String>()

    companion object {
        const val LOG_MAIN = "log_main"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add(R.id.fragmentContainerViewMain, LogFragment())
        }
        addLog("onCreate")
    }

    @Deprecated("Deprecated in Java")
    override fun onAttachFragment(fragment: androidx.fragment.app.Fragment) {
        super.onAttachFragment(fragment)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addLog("onAttachFragment")
    }

    override fun onStart() {
        super.onStart()
        addLog("onStart")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        addLog("onRestoreInstanceState")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        addLog("onPostCreate")
    }

    override fun onResume() {
        super.onResume()
        addLog("onResume")
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        addLog("onResumeFragment")
    }

    override fun onPostResume() {
        super.onPostResume()
        addLog("onPostResume")
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        addLog("onAttachedToWindow")
    }

    override fun onPause() {
        super.onPause()
        addLog("onPause")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        addLog("onSaveInstanceState")
    }

    override fun onStop() {
        super.onStop()
        addLog("onStop")
    }

    override fun onRestart() {
        super.onRestart()
        addLog("onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        addLog("onDestroy")
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        addLog("onDetachedFromWindow")
    }

    private fun addLog(method: String) {
        logList.add(method)
        Log.e(LOG_MAIN, method)
        if (logList.count() > 8) {
            val itemForDelete = logList.first()
            logList.remove(itemForDelete)
        }
        if (lifecycle.currentState.ordinal > Lifecycle.State.CREATED.ordinal) {
            binding.textViewMain.text = ""
            for (log in logList) {
                binding.textViewMain.text =
                    String.format(getString(R.string.log), binding.textViewMain.text, log)
            }
        }
    }
}