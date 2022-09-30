package com.express.testedesenvolvedorsicredi.features.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.express.desafio02.R
import com.express.desafio02.databinding.ItemListHomeBinding
import com.express.desafio02.features.home.data.model.HomeResponse

class HomeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<HomeResponse> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(
            ItemListHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> {
                val itemsPosition = items[position]
                holder.bind(itemsPosition)
            }
        }
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun setDataSet(service: List<HomeResponse>) {
        this.items = service
        notifyDataSetChanged()
    }

    class HomeViewHolder(
        val binding: ItemListHomeBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(service: HomeResponse) {
            binding.apply {
                txtTitle.text = service.title
                txtData.text = service.date.toString()
                txtPrice.text = service.price.toString()

                val requetOptions = RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)

                Glide.with(imgItemList.context)
                    .applyDefaultRequestOptions(requetOptions)
                    .load(service.image)
                    .into(imgItemList)

            }
        }
    }
}