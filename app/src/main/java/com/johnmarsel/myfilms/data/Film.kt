package com.johnmarsel.myfilms.data

data class Film (
    val title: String,
    val directorName: String,
    val releaseYear: Int,
    val actors: List<Actor>
        )