package com.johnmarsel.myfilms.ui.films

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.*
import com.johnmarsel.myfilms.data.FilmsRepository
import com.johnmarsel.myfilms.data.Resource
import com.johnmarsel.myfilms.data.model.Film
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmsViewModel @Inject constructor(
    private val repository: FilmsRepository
) : ViewModel() {

    private val _films = MutableLiveData<Resource<List<Film>>>()
    val films: LiveData<Resource<List<Film>>> = _films

    init {
        getFilms()
    }

    private fun getFilms() {
        viewModelScope.launch {
            repository.getFilms().collect {
                _films.value = it
            }
        }
    }

    fun onRefresh() {
        getFilms()
    }
}