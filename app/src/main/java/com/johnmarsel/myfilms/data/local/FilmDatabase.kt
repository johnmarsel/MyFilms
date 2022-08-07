package com.johnmarsel.myfilms.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.johnmarsel.myfilms.data.model.Film

@Database(entities = [ Film::class], version=1)
@TypeConverters(Converters::class)
abstract class FilmDatabase : RoomDatabase() {
    abstract fun filmDao(): FilmDao
}