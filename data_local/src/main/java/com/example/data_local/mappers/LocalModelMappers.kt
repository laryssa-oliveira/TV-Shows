package com.example.data_local.mappers

import com.example.data_local.model.ShowGenreLocal
import com.example.data_local.model.ShowImageLocal
import com.example.data_local.model.ShowLocal
import com.example.domain.entities.Show
import com.example.domain.entities.ShowGenre
import com.example.domain.entities.ShowImage

object LocalModelMappers {

    fun Show.toLocalModel() =
        ShowLocal(
            id = id,
            name = name,
            summary = summary,
            image = image?.toLocalModel(),
            officialSite = officialSite,
            genres = genres?.toLocalModel(),
            status = status,
            favorite = favorite
        )

    fun ShowImage.toLocalModel() =
        ShowImageLocal(
            id = id,
            medium = medium,
            original = original
        )

    fun ShowGenre.toLocalModel() =
        ShowGenreLocal(
            id = id,
            genres = genre
        )

    fun ShowLocal.toModel() =
        Show(
            id = id,
            name = name,
            summary = summary,
            image = image?.toModel(),
            officialSite = officialSite,
            genres = genres?.toModel(),
            status = status,
            favorite = favorite
        )

    fun ShowImageLocal.toModel() =
        ShowImage(
            id = id,
            medium = medium,
            original = original
        )

    fun ShowGenreLocal.toModel() =
        ShowGenre(
            id = id,
            genre = genres
        )

    fun List<ShowLocal>.toModel() = this.map { it.toModel() }


}