package com.example.feature_main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.base_feature.navDirections
import com.example.feature_main.databinding.FragmentHomeBinding
import com.example.feature_main.navigation.HomeNavigation

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val navigation: HomeNavigation by navDirections()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

}


