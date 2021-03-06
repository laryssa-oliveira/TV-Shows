package com.example.domain.entities

data class Show(
    val id: Int,
    val name: String,
    val summary: String,
    val image: ShowImage,
    val officialSite: String,
    val genres: List<String>,
    val status: String,
    var favorite: Boolean
)

data class ShowImage(
    val medium: String,
    val original: String

)