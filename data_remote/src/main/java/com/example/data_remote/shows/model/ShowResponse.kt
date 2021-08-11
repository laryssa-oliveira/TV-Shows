package com.example.data_remote.shows.model

import com.google.gson.annotations.SerializedName

data class ShowResponse (

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("summary")
    val summary: String,

    @SerializedName("image")
    val image: ShowImageResponse,

    @SerializedName("officialSite")
    val officialSite: String? = null,

    @SerializedName("genres")
    val genres: ShowGenreResponse,

    @SerializedName("status")
    val status: String
)