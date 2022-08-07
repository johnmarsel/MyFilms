package com.johnmarsel.myfilms.data.remote

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val filmsApi: FilmsApi
)  {

    suspend fun fetchFilms() = filmsApi.fetchFilms().items
}