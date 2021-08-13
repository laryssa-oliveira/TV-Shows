package com.example.feature_main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.example.base_feature.navDirections
import com.example.feature_main.databinding.FragmentHomeBinding
import com.example.feature_main.navigation.HomeNavigation
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var pagerAdapter: PagerAdapter
    private val navigation: HomeNavigation by navDirections()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



    }
}
