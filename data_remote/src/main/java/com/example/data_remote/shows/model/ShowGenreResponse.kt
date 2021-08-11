package com.example.data_remote.shows.model

import com.google.gson.annotations.SerializedName

data class ShowGenreResponse(

    @SerializedName("genres")
    val genre: String
)