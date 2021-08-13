package com.example.data_remote.mappers

import com.example.data_remote.shows.model.GetShowsResponse
import com.example.data_remote.shows.model.ShowImageResponse
import com.example.data_remote.shows.model.ShowResponse
import com.example.domain.entities.Show
import com.example.domain.entities.ShowImage

fun ShowResponse.toModel(): Show {
    return Show(
        id = id ?: 0,
        name = name ?: "",
        summary = summary ?: "",
        image = (image ?: ShowImageResponse("", "")).toModel(),
        officialSite = officialSite ?: "",
        genres = genres ?: listOf(),
        status = status ?: "",
        favorite = false
    )
}

fun ShowImageResponse.toModel(): ShowImage {
    return ShowImage(
        medium = medium ?: "",
        original = original ?: ""
    )
}

fun GetShowsResponse.fromListResponse(): List<Show>{
    return this.shows.map { it.toModel() }
}