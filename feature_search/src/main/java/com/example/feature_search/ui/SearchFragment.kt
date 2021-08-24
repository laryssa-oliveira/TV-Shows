package com.example.feature_search.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import com.example.base_feature.ShowAdapter
import com.example.base_feature.ViewState
import com.example.base_feature.mappers.ShowMapper.toShowModel
import com.example.base_feature.model.ShowPresentation
import com.example.base_feature.navDirections
import com.example.base_feature.viewState
import com.example.domain.entities.Show
import com.example.feature_search.navigation.SearchNavigation
import com.example.feature_search.presentation.SearchViewModel
import feature_search.databinding.FragmentSearchBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val searchViewModel by viewModel<SearchViewModel>()
    private val navigation: SearchNavigation by navDirections()
    private lateinit var adapter: ShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchShow.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                searchViewModel.search(s.toString())

            }
        })

        setObservers()
    }

    private fun setObservers() {
        searchViewModel.showListLiveData.observe(viewLifecycleOwner, {
            when (it.state) {

                ViewState.State.SUCCESS -> onSuccess(it.data ?: listOf<ShowPresentation>())
                ViewState.State.ERROR -> onResultError(it.error)
                ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })

        searchViewModel.searchShow.observe(viewLifecycleOwner, {
            when (it.state) {

                ViewState.State.SUCCESS -> onSuccessSearch(it.data ?: listOf<Show>())
                ViewState.State.ERROR -> onResultError(it.error)
                ViewState.State.LOADING -> onLoading(it.isLoading)
            }
        })

    }

    private fun onLoading(loading: Boolean) {
        if (loading)
            binding.loadingGroupSearch.visibility = View.VISIBLE
        else
            binding.loadingGroupSearch.visibility = View.GONE

    }

    private fun onResultError(error: Throwable?) {
        Toast.makeText(requireContext(), error?.message ?: "", Toast.LENGTH_LONG).show()
    }

    private fun onSuccess(list: List<ShowPresentation>) {
        onLoading(false)
        adapter = ShowAdapter(callback = ::clickItem)
        adapter.setItems(list)
        binding.recyclerViewSearch.adapter = adapter
    }

    private fun onSuccessSearch(list: List<Show>) {
        onLoading(false)
        adapter = ShowAdapter(callback = ::clickItem)
        adapter.setItems(list.toShowModel())
        binding.recyclerViewSearch.adapter = adapter
        binding.recyclerViewSearch.visibility = View.VISIBLE
        binding.cardSearch.visibility = View.GONE

    }

    private fun clickItem(show: ShowPresentation) {
        navigation.navigateToDetails(show)
    }

}