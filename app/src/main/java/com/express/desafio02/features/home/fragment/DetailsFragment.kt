package com.express.desafio02.features.home.fragment

import com.express.desafio02.R
import com.express.desafio02.databinding.FragmentHomeBinding
import com.express.desafio02.features.home.viewModel.HomeViewModel
import com.express.desafio02.core.abstractions.fragment.BaseFragment
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailsFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun layout() = R.layout.fragment_details

    override fun init() {

    }

}
