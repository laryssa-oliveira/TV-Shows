package com.example.intent

import androidx.fragment.app.Fragment
import com.example.base_feature.model.ShowPresentation
import com.example.feature_main.navigation.HomeNavigation
import com.example.feature_main.ui.MainFragmentDirections
import com.example.intent.utils.navigate

class HomeNavigationImpl (private val fragment: Fragment) : HomeNavigation {
    override fun navigateToDetails(show: ShowPresentation) = fragment.navigate(
        MainFragmentDirections.actionMainFragmentToDetailsFragment(show)
    )
}