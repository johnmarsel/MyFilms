package com.johnmarsel.myfilms.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class Film (
    @PrimaryKey val title: String,
    val directorName: String,
    val releaseYear: Int,
    val actors: List<Actor>
    )