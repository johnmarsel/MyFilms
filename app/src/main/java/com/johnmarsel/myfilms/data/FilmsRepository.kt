package com.johnmarsel.myfilms.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.johnmarsel.myfilms.data.local.LocalDataSource
import com.johnmarsel.myfilms.data.remote.FilmsApi
import com.johnmarsel.myfilms.data.model.Film
import com.johnmarsel.myfilms.data.remote.RemoteDataSource
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmsRepository @Inject constructor(
    private val remoteRepository: RemoteDataSource,
    private val localRepository: LocalDataSource
)  {

    fun getFilms(): Flow<Resource<List<Film>>>
    = flow {
        val data = localRepository.getFilms().first()

        val shouldFetch = data.isEmpty()

        val flow = if (shouldFetch) {
            emit(Resource.Loading(data))

            try {
                val films = remoteRepository.fetchFilms()
                localRepository.insertFilms(films)
                localRepository.getFilms().map { Resource.Success(it) }
            } catch (throwable: Throwable) {
                localRepository.getFilms().map { Resource.Error(throwable, it) }
            }
        } else {
            localRepository.getFilms().map { Resource.Success(it) }
        }
        emitAll(flow)
    }
}