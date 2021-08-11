package com.example.data_remote.shows.model

import com.example.data_remote.shows.model.ShowResponse
import com.google.gson.annotations.SerializedName

data class GetShowsResponse(

    @SerializedName("shows")
    val shows: List<ShowResponse>
)