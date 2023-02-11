package com.example.lesson_2_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.setFragmentResultListener
import com.example.lesson_2_1.R
import com.example.lesson_2_1.databinding.FragmentMainFlowBinding

class MainFlowFragment : Fragment(R.layout.fragment_main_flow) {

    private lateinit var binding: FragmentMainFlowBinding

    private lateinit var message: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        message = getString(R.string.text_view_main_flow)

        setFragmentResultListener(EditFragment.MESSAGE_RESULT_KEY) { _, bundle ->
            message = bundle.getCharSequence(EditFragment.MESSAGE_BUNDLE_KEY).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainFlowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonMainFlow.setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(
                    R.id.fragmentContainerViewMain,
                    EditFragment.newInstance(binding.textViewMainFlow.text.toString())
                )
                addToBackStack(null)
            }
        }
    }

    override fun onResume() {
        super.onResume()

        binding.textViewMainFlow.text = message
    }
}