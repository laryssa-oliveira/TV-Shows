package com.example.feature_main.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.feature_main.databinding.FragmentFavoriteShowsBinding


class FavoriteShowsFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteShowsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

}