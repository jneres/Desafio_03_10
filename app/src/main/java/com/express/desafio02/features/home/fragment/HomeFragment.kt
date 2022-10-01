package com.express.desafio02.features.home.fragment

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.express.desafio02.R
import com.express.desafio02.databinding.FragmentHomeBinding
import com.express.desafio02.features.home.viewModel.HomeViewModel
import com.express.desafio02.core.abstractions.fragment.BaseFragment
import com.express.desafio02.features.home.adapter.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by sharedViewModel()
    private var homeAdapter: HomeAdapter? = null

    override fun layout() = R.layout.fragment_home


    override fun init() {
        setObservers()
        initRecyclerview()
        setEvents()
    }

    private fun setEvents() {
        viewModel.getItens()
    }

    private fun setObservers() {
        viewModel.loading.observe(viewLifecycleOwner) {
            showLoading(it)
        }

        binding.apply {
            viewModel.homeData.observe(viewLifecycleOwner) { response ->
                if (response != null) {
                    homeAdapter?.setDataSet(response)
                }
            }

            viewModel.homeDataItem.observe(viewLifecycleOwner) {
                if (it != null) {
                    navigate(R.id.DetailsFragment)
                }
            }
        }
    }

    private fun initRecyclerview() {
        binding?.apply {
            homeAdapter = HomeAdapter() {
                getItensDetails(it)
            }

            homeRecycler.layoutManager = LinearLayoutManager(requireContext())
            homeRecycler.adapter = homeAdapter
        }
    }

    private fun getItensDetails(idItem: Int) {
        viewModel.getItensDetails(idItem)
    }
}


