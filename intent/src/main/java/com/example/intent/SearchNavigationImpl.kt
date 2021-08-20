package com.example.intent

import androidx.fragment.app.Fragment
import com.example.base_feature.model.ShowPresentation
import com.example.feature_search.navigation.SearchNavigation
import com.example.feature_search.ui.SearchFragmentDirections
import com.example.intent.utils.navigate

class SearchNavigationImpl (private val fragment: Fragment) : SearchNavigation {
    override fun navigateToDetails(show: ShowPresentation) = fragment.navigate(
        SearchFragmentDirections.actionSearchFragmentToDetailsFragment(show)
    )
}