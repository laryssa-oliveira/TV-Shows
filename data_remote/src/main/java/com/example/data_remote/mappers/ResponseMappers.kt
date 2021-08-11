package com.example.data_remote.mappers

import com.example.data_remote.shows.model.GetShowsResponse
import com.example.data_remote.shows.model.ShowGenreResponse
import com.example.data_remote.shows.model.ShowImageResponse
import com.example.data_remote.shows.model.ShowResponse
import com.example.domain.entities.Show
import com.example.domain.entities.ShowGenre
import com.example.domain.entities.ShowImage

fun ShowResponse.toModel(): Show {
    return Show(
        id = id,
        name = name,
        summary = summary,
        image = image.toModel(),
        officialSite = officialSite,
        genres = genres.toModel(),
        status = status
    )
}

fun ShowImageResponse.toModel(): ShowImage {
    return ShowImage(
        medium = medium,
        original = original
    )
}

fun ShowGenreResponse.toModel(): ShowGenre {
    return ShowGenre(
        genre = genre
    )
}

fun GetShowsResponse.fromListResponse(): List<Show>{
    return this.shows.map { it.toModel() }
}