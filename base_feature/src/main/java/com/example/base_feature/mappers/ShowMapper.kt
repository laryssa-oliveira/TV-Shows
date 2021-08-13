package com.example.base_feature.mappers

import com.example.base_feature.mappers.ShowMapper.toShowModel
import com.example.base_feature.model.ShowImagePresentation
import com.example.base_feature.model.ShowPresentation
import com.example.domain.entities.Show
import com.example.domain.entities.ShowImage

object ShowMapper {
    fun Show.toShowModel() =
        ShowPresentation(
            id = id,
            name = name,
            summary = summary,
            image = image.toShowModel(),
            officialSite = officialSite,
            genres = genres,
            status = status,
            favorite = favorite
        )

    fun ShowImage.toShowModel() =
        ShowImagePresentation(
            medium = medium,
            original = original
        )

    fun List<Show>.toShowModel() = this.map { it.toShowModel() }
}