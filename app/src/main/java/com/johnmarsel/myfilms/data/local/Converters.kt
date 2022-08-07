package com.johnmarsel.myfilms.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.johnmarsel.myfilms.data.model.Actor

class Converters {

    @TypeConverter
    fun listToJsonString(value: List<Actor>?): String = Gson().toJson(value)

    @TypeConverter
    fun jsonStringToList(value: String) = Gson().fromJson(value, Array<Actor>::class.java).toList()
}