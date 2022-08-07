package com.johnmarsel.myfilms.ui.films

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.johnmarsel.myfilms.data.FilmsRepository
import com.johnmarsel.myfilms.data.Resource
import com.johnmarsel.myfilms.data.model.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    repository: FilmsRepository
) : ViewModel() {

    val films: LiveData<Resource<List<Film>>> = repository.getFilms().asLiveData()
}