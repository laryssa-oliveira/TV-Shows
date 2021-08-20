package com.example.di.intent

import androidx.fragment.app.Fragment
import com.example.feature_search.navigation.SearchNavigation
import com.example.intent.SearchNavigationImpl
import org.koin.dsl.module

val intentSearchModule = module {
    factory<SearchNavigation> { (fragment: Fragment) ->
        SearchNavigationImpl(fragment)
    }
}