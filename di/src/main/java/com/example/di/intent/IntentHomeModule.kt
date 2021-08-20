package com.example.di.intent

import androidx.fragment.app.Fragment
import com.example.base_feature.details.DetailsNavigation
import com.example.feature_main.navigation.HomeNavigation

import com.example.intent.HomeNavigationImpl
import com.example.intent.DetailsNavigationImpl
import org.koin.dsl.module

val intentHomeModule = module {
    factory<HomeNavigation> { (fragment: Fragment) ->
        HomeNavigationImpl(fragment)
    }

    factory<DetailsNavigation> { (fragment: Fragment) ->
        DetailsNavigationImpl(fragment)
    }
}