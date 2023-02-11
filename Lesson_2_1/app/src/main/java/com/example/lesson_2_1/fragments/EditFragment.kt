package com.example.lesson_2_1.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.lesson_2_1.R
import com.example.lesson_2_1.databinding.FragmentEditBinding

class EditFragment : Fragment(R.layout.fragment_edit) {

    private lateinit var binding: FragmentEditBinding

    companion object {
        private const val MESSAGE_ARGUMENT = "MESSAGE_ARGUMENT"

        const val MESSAGE_RESULT_KEY = "MESSAGE_RESULT_KEY"
        const val MESSAGE_BUNDLE_KEY = "MESSAGE_BUNDLE_KEY"

        fun newInstance(message: String): EditFragment {
            val arguments = Bundle()
            arguments.putString(MESSAGE_ARGUMENT, message)

            val fragment = EditFragment()
            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEditBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editTextEdit.setText(requireArguments().getString(MESSAGE_ARGUMENT))

        binding.buttonEdit.setOnClickListener {
            val text = binding.editTextEdit.text
            setFragmentResult(MESSAGE_RESULT_KEY, bundleOf(MESSAGE_BUNDLE_KEY to text))
            parentFragmentManager.popBackStack()
        }
    }
}