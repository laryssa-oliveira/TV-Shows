package com.example.base_feature.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.base_feature.GenreAdapter
import com.example.base_feature.R
import com.example.base_feature.databinding.FragmentDetailsBinding
import com.example.base_feature.navDirections

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val navigation: DetailsNavigation by navDirections()
    private val adapter = GenreAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter.setItems(navigation.show.genres)
        binding.genreShow.adapter = adapter
        binding.showName.text = navigation.show.name
        Glide
            .with(this)
            .load(navigation.show.image.original)
            .placeholder(R.drawable.ic_broken_image)
            .into(binding.imageViewDetails)
        binding.descriptionShow.text = navigation.show.summary
    }

}