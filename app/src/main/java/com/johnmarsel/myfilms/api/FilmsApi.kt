package com.johnmarsel.myfilms.api

import retrofit2.http.GET

interface FilmsApi {

    @GET("constanta-android-dev/intership-wellcome-task/main/films.json")
    suspend fun fetchFilms(): ApiResponse

    companion object {
        const val BASE_URL = "https://raw.githubusercontent.com/"
    }
}