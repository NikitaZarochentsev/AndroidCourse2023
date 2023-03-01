package com.example.lesson_3.presentation.ui.signin

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.lesson_3.R
import com.example.lesson_3.databinding.FragmentSignInBinding
import com.example.lesson_3.presentation.ui.catalog.CatalogFragment

class SignInFragment : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSignIn.setOnClickListener {
            navigateToCatalog()
        }
        binding.textPasswordSignIn.setOnEditorActionListener { _, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE ||
                event.action == KeyEvent.ACTION_DOWN &&
                event.keyCode == KeyEvent.KEYCODE_ENTER
            ) {
                navigateToCatalog()
                true
            } else {
                false
            }
        }
    }

    private fun navigateToCatalog() {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.containerMain, CatalogFragment())
            addToBackStack(null)
        }
    }
}