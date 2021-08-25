package com.example.di.intent

import androidx.fragment.app.Fragment
import com.example.feature_favorite.navigation.FavoriteNavigation
import com.example.intent.FavoriteNavigationImpl
import org.koin.dsl.module

val intentFavoriteModule = module {
    factory<FavoriteNavigation> { (fragment: Fragment) ->
        FavoriteNavigationImpl(fragment)
    }
}