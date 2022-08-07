package com.johnmarsel.myfilms.data.local

import androidx.room.withTransaction
import com.johnmarsel.myfilms.data.model.Film
import com.johnmarsel.myfilms.data.remote.FilmsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalDataSource @Inject constructor(
    private val db: FilmDatabase
)  {
    private val filmDao = db.filmDao()

    fun getFilms() = filmDao.getFilms()

    suspend fun insertFilms(films: List<Film>){
        db.withTransaction {
            filmDao.insertFilms(films)
        }
    }
}