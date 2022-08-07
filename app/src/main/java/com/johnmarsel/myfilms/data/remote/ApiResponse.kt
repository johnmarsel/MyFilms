package com.johnmarsel.myfilms.data.remote

import com.johnmarsel.myfilms.data.model.Film

data class ApiResponse(
    val items: List<Film>
)