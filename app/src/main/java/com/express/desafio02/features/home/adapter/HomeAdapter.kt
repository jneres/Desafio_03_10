package com.express.testedesenvolvedorsicredi.features.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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
                holder.binding.apply {

                }
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

        @SuppressLint("SetTextI18n")
        fun bind(service: HomeResponse) {
            binding.apply {
                txtTitle.text = service.title
                txtData.text = "Data: ${service.date.toString()}"
                txtPrice.text = "Preço: ${service.price.toString()}"


            }
        }

    }
}