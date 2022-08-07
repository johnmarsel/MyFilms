package com.johnmarsel.myfilms.ui.films

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.johnmarsel.myfilms.data.Resource
import com.johnmarsel.myfilms.databinding.FragmentFilmsBinding
import com.johnmarsel.myfilms.ui.dialog.FilmDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FilmsFragment : Fragment() {

    private val viewModel: FilmsViewModel by viewModels()
    private lateinit var binding: FragmentFilmsBinding
    private var adapter = FilmsAdapter(emptyList(), null)

    private val clickFilmAction: ClickFilmAction = { title ->
        FilmDialogFragment.let {
            it.newInstance(title).show(parentFragmentManager, it.FILM_DIALOG)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFilmsBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.recyclerViewFilms.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.films.observe(
            viewLifecycleOwner
        ) { result ->
            binding.apply {
                progressLoading.isVisible = result is Resource.Loading && result.data.isNullOrEmpty()
                textViewError.isVisible = result is Resource.Error && result.data.isNullOrEmpty()
            }
            if (result is Resource.Success) {
                val sortedFilms = result.data?.sortedBy { it.releaseYear }
                sortedFilms?.let {
                    adapter = FilmsAdapter(sortedFilms, clickFilmAction)
                    binding.recyclerViewFilms.adapter = adapter
                }
            }
        }
    }
}