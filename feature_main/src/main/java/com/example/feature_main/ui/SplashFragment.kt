package com.example.feature_main.ui

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.base_feature.navDirections
import com.example.feature_main.databinding.FragmentSplashBinding
import com.example.feature_main.navigation.SplashNavigation

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding
    private val navigation: SplashNavigation by navDirections()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        Handler(requireActivity().mainLooper).postDelayed({
            navigation.navigateToHome()
        }, 2500)
    }

}