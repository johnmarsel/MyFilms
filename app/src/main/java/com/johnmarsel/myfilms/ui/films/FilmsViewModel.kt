package com.johnmarsel.myfilms.ui.films

import androidx.lifecycle.ViewModel
import com.johnmarsel.myfilms.data.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    repository: FilmsRepository
) : ViewModel() {

    val films = repository.getFilms()
}