package com.example.base_feature.model

import java.io.Serializable

data class ShowPresentation(
    val id: Int,
    val name: String,
    val summary: String,
    val image: ShowImagePresentation,
    val officialSite: String,
    val genres: List<String>,
    val status: String,
    var favorite: Boolean
): Serializable

data class ShowImagePresentation(
    val medium: String,
    val original: String

): Serializable