package com.express.desafio02.features.home.fragment

import androidx.navigation.fragment.findNavController
import com.express.desafio02.R
import com.express.desafio02.core.abstractions.fragment.BaseFragment
import com.express.desafio02.core.abstractions.utils.toCurrency
import com.express.desafio02.databinding.FragmentDetailsBinding
import com.express.desafio02.features.home.viewModel.HomeViewModel
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    private val viewModel: HomeViewModel by sharedViewModel()

    override fun layout() = R.layout.fragment_details

    override fun init() {
        setItems()
        observItens()
        buttonsNav()
        sendDetails()
    }

    private fun observItens() {
        viewModel.loading.observe(viewLifecycleOwner) {
            showLoading(it)
        }

        viewModel.checkin.observe(viewLifecycleOwner) {

            binding?.txtMenssage?.text = it.toString()

        }
    }

    private fun buttonsNav() {
        binding?.apply {
            btnBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setItems() {
        binding?.apply {
            viewModel.apply {
                txtTitle.text = homeResponse?.title
                txtValueData.text = homeResponse?.date.toString()
                txtValuePrice.text = homeResponse?.price?.toCurrency()
                txtValueLatitude.text = homeResponse?.latitude.toString()
                txtValueLongitude.text = homeResponse?.longitude.toString()
                txtDescription.text = homeResponse?.description


                Picasso.get().load(homeResponse?.image)
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(imgItemList)
            }
        }
    }

    fun sendDetails() {
        binding?.apply {
            val idItem = viewModel.homeResponse?.idItem
            btnCheckin.setOnClickListener {
                viewModel.setDetails(
                    idItem.toString(),
                    txtName.text.toString(),
                    txtEmail.text.toString()
                )
            }
        }
    }
}
