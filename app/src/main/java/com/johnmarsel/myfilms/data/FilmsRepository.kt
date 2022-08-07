package com.johnmarsel.myfilms.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.johnmarsel.myfilms.api.FilmsApi
import com.johnmarsel.myfilms.data.model.Film
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmsRepository @Inject constructor(
    private val filmsApi: FilmsApi
)  {

    fun getFilms(): LiveData<List<Film>> =
        liveData {
            val res = filmsApi.fetchFilms().items
            emit(res)
        }

}