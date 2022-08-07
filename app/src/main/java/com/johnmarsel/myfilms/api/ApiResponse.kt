package com.johnmarsel.myfilms.api

import com.johnmarsel.myfilms.data.model.Film

data class ApiResponse(
    val items: List<Film>
)