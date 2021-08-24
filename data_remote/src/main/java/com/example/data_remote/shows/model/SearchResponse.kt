package com.example.data_remote.shows.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (

    @SerializedName("show")
    val showResponse: ShowResponse
)