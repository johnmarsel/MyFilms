package com.johnmarsel.myfilms.data

import com.johnmarsel.myfilms.api.FilmsApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilmsRepository @Inject constructor(
    private val filmsApi: FilmsApi
)  {
}