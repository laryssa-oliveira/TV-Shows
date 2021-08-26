package com.example.intent

import androidx.fragment.app.Fragment
import com.example.base_feature.model.ShowPresentation
import com.example.feature_favorite.navigation.FavoriteNavigation
import com.example.feature_favorite.ui.FavoriteShowFragmentDirections
import com.example.intent.utils.navigate

class FavoriteNavigationImpl(private val fragment: Fragment) : FavoriteNavigation {
    override fun navigateToDetails(show: ShowPresentation) = fragment.navigate(
        FavoriteShowFragmentDirections.actionFavoriteShowFragmentToDetailsFragment(show)
    )
}