package com.example.data_local.mappers

import com.example.data_local.model.ShowImageLocal
import com.example.data_local.model.ShowLocal
import com.example.domain.entities.Show
import com.example.domain.entities.ShowImage

object LocalModelMappers {

    fun Show.toLocalModel() =
        ShowLocal(
            id = id,
            name = name,
            summary = summary,
            image = image.toLocalModel(),
            officialSite = officialSite,
            genres = genres,
            status = status,
            favorite = favorite
        )

    fun ShowImage.toLocalModel() =
        ShowImageLocal(
            medium = medium,
            original = original
        )

    fun ShowLocal.toModel() =
        Show(
            id = id,
            name = name,
            summary = summary,
            image = image.toModel(),
            officialSite = officialSite,
            genres = genres,
            status = status,
            favorite = favorite
        )

    fun ShowImageLocal.toModel() =
        ShowImage(
            medium = medium,
            original = original
        )


    fun List<ShowLocal>.toModel() = this.map { it.toModel() }


}