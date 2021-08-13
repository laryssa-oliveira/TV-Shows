package com.example.data_remote.shows.model

import com.google.gson.annotations.SerializedName

data class ShowResponse (

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("summary")
    val summary: String? = null,

    @SerializedName("image")
    val image: ShowImageResponse? = null,

    @SerializedName("officialSite")
    val officialSite: String? = null,

    @SerializedName("genres")
    val genres: List<String>? = null,

    @SerializedName("status")
    val status: String? = null
)