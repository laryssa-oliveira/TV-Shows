package com.example.data_remote.shows.model

import com.google.gson.annotations.SerializedName

data class ShowImageResponse (
    @SerializedName("medium")
    val medium: String,

    @SerializedName("original")
    val original: String
)