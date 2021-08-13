package com.example.feature_main.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PageAdapter(fm: FragmentManager?, private val tabCount: Int) :
    FragmentPagerAdapter(fm!!, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SearchFragment()
            1 -> MainFragment()
            else -> FavoriteShowsFragment()
        }
    }

    override fun getCount(): Int {
        return tabCount
    }

    override fun getItemPosition(`object`: Any): Int {
        return POSITION_NONE
    }
}