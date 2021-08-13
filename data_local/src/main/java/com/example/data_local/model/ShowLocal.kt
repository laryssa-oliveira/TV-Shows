package com.example.data_local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.data_local.database.DatabaseConverter

@Entity(tableName = "shows_table")
@TypeConverters(DatabaseConverter::class)
data class ShowLocal(
    @PrimaryKey var id: Int,
    var favorite: Boolean,
    val name: String,
    val summary: String,
    val image: ShowImageLocal,
    val officialSite: String,
    val genres: List<String>,
    val status: String
)

@Entity(tableName = "shows_image_table")
class ShowImageLocal (
    @PrimaryKey val medium: String,
    val original: String
)

