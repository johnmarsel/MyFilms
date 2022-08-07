package com.johnmarsel.myfilms.data.local

import com.johnmarsel.myfilms.data.model.Film
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    db: FilmDatabase
)  {
    private val filmDao = db.filmDao()

    fun getFilms() = filmDao.getFilms()

    suspend fun insertFilms(films: List<Film>){
        filmDao.insertFilms(films)
    }
}