package com.example.intent

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.base_feature.details.DetailsFragmentArgs
import com.example.base_feature.details.DetailsNavigation

class DetailsNavigationImpl(fragment: Fragment): DetailsNavigation {
    private val args = fragment.navArgs<DetailsFragmentArgs>().value
    override val show = args.show
}