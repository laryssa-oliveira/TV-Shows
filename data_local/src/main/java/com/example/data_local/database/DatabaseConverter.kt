package com.example.data_local.database

import androidx.room.TypeConverter
import com.example.data_local.model.ShowGenreLocal
import com.example.data_local.model.ShowImageLocal
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DatabaseConverter {
    @TypeConverter
    fun toShowGenreLocal(string: String): ShowGenreLocal {
        val type = object : TypeToken<ShowGenreLocal>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun toShowImageLocal(string: String): ShowImageLocal {
        val type = object : TypeToken<ShowImageLocal>() {}.type
        return Gson().fromJson(string, type)
    }

    @TypeConverter
    fun fromShowGenreLocal(string: ShowGenreLocal): String {
        return Gson().toJson(string)
    }

    @TypeConverter
    fun fromShowImageLocal(string: ShowImageLocal): String {
        return Gson().toJson(string)
    }
}