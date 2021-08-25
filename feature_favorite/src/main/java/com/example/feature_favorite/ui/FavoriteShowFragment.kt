package com.example.feature_favorite.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.base_feature.ViewState
import com.example.base_feature.model.ShowPresentation
import com.example.base_feature.navDirections
import com.example.feature_favorite.databinding.FragmentFavoriteShowBinding
import com.example.feature_favorite.navigation.FavoriteNavigation
import com.example.feature_favorite.presentation.FavoriteShowViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteShowFragment : Fragment() {

    private lateinit var adapter: FavoriteShowAdapter
    private val favShowViewModel by viewModel<FavoriteShowViewModel>()
    private lateinit var binding: FragmentFavoriteShowBinding
    private val navigation: FavoriteNavigation by navDirections()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteShowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favShowViewModel.getFavoriteShows()

        setObservers()
    }

    private fun setObservers() {
        favShowViewModel.showListLiveData.observe(viewLifecycleOwner, {
            when (it.state) {

                ViewState.State.SUCCESS -> onSuccess(it.data ?: listOf())
                ViewState.State.ERROR -> onResultError(it.error)
                ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })

    }

    private fun onSuccess(list: List<ShowPresentation>) {
        onLoading(false)
        adapter = FavoriteShowAdapter(
            callback = ::clickItem,
            callbackLike = ::clickLikeItem,
            callbackUpdateUi = { updateUI(it) })
        adapter.setItems(list.toMutableList())
        binding.recyclerViewFavorite.adapter = adapter
        updateUI(list)
    }


    private fun clickItem(show: ShowPresentation) {
        navigation.navigateToDetails(show)

    }

    private fun clickLikeItem(like: Boolean, show: ShowPresentation) {
        favShowViewModel.favoriteShows(like, show)
    }


    private fun onLoading(loading: Boolean) {
        if (loading)
            binding.loadingGroupFavorite.visibility = View.VISIBLE
        else
            binding.loadingGroupFavorite.visibility = View.GONE

    }

    private fun onResultError(error: Throwable?) {
        Toast.makeText(requireContext(), error?.message ?: "", Toast.LENGTH_LONG).show()
    }


    private fun updateUI(list: List<ShowPresentation>) {

        if (list.isNotEmpty()) {
            binding.recyclerViewFavorite.visibility = View.VISIBLE
            binding.cardNoFavorite.visibility = View.GONE
        } else {
            binding.recyclerViewFavorite.visibility = View.GONE
            binding.cardNoFavorite.visibility = View.VISIBLE
        }
    }

}