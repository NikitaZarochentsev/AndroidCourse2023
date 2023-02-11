package com.example.lesson_2_4

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.lesson_2_4.databinding.FragmentLogBinding

class LogFragment : Fragment() {

    private lateinit var binding: FragmentLogBinding

    private val logList = ArrayList<String>()

    companion object {
        const val LOG_FRAGMENT = "log_fragment"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        addLog("onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addLog("onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLogBinding.inflate(inflater, container, false)
        addLog("onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addLog("onViewCreated")
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addLog("onActivityCreated")
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        addLog("onViewStateRestored")
    }

    override fun onStart() {
        super.onStart()
        addLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        addLog("onResume")
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

    override fun onDestroyView() {
        super.onDestroyView()
        addLog("onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        addLog("onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        addLog("onDetach")
    }

    private fun addLog(method: String) {
        logList.add(method)
        Log.e(LOG_FRAGMENT, method)
        if (logList.count() > 8) {
            val itemForDelete = logList.first()
            logList.remove(itemForDelete)
        }
        if (lifecycle.currentState.ordinal > Lifecycle.State.CREATED.ordinal) {
            binding.textViewLog.text = ""
            for (log in logList) {
                binding.textViewLog.text =
                    String.format(getString(R.string.log), binding.textViewLog.text, log)
            }
        }
    }
}