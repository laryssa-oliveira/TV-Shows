package com.example.domain.entities

import java.io.Serializable

data class Show(
    val id: Int=0,
    val name: String = "",
    val summary: String = "",
    val image: ShowImage? = null,
    val officialSite: String? = "",
    val genres: ShowGenre? = null,
    val status: String = "",
    var favorite: Boolean = false
): Serializable

data class ShowGenre(
    val id: Int=0,
    val genre: String = ""

): Serializable

data class ShowImage(
    val id: Int=0,
    val medium: String = "",
    val original: String = ""

): Serializable