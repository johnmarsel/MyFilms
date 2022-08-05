package com.johnmarsel.myfilms.data

data class Film (
    val title: String,
    val directorName: String,
    val releaseYear: String,
    val actors: List<Actor>
        )