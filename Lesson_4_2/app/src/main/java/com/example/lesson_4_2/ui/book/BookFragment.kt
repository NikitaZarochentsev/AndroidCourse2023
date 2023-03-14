package com.example.lesson_4_2.ui.book

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.lesson_4_2.R
import com.example.lesson_4_2.databinding.FragmentBookBinding
import com.example.lesson_4_2.domain.BookViewModel

class BookFragment : Fragment() {

    private lateinit var binding: FragmentBookBinding

    private val viewModel: BookViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.bookListUiState.observe(this as LifecycleOwner) { result ->
            result
                .onSuccess {
                    var booksList = String()
                    for (author in it.authorListResult) {
                        booksList += getString(R.string.author_title_text, author.nameAuthor)
                        for (book in author.bookList) {
                            booksList += if (book.availability) {
                                getString(R.string.availability_text, book.nameBook)
                            } else {
                                getString(R.string.no_availability_text, book.nameBook)
                            }
                        }
                    }
                    binding.textViewListBook.text = booksList
                }
                .onFailure {
                    when (it) {
                        is BookViewModel.GetBooksException -> binding.textViewErrorBook.text =
                            getString(R.string.error_text_get_books_exception)
                        is BookViewModel.GetAuthorsException -> binding.textViewErrorBook.text =
                            getString(R.string.error_text_get_authors_exception)
                        is BookViewModel.GetAvailabilityException -> binding.textViewErrorBook.text =
                            getString(R.string.error_text_get_availability_exception)
                    }
                }
        }

        binding.buttonGetBook.setOnClickListener {
            binding.textViewErrorBook.text = null
            viewModel.updateBookListUiState()
            binding.buttonGetBook.text = getString(R.string.button_text_repeat)
        }
    }
}