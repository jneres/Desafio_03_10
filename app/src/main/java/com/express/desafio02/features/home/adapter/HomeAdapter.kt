package com.express.desafio02.features.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.express.desafio02.R
import com.express.desafio02.databinding.ItemListHomeBinding
import com.express.desafio02.features.home.data.model.HomeResponse
import com.squareup.picasso.Picasso


class HomeAdapter(
    var callback: (id: Int) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<HomeResponse> = ArrayList()
    var idSelected = 0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return HomeViewHolder(
            ItemListHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is HomeViewHolder -> {
                val currentItem = items[position]
                holder.bind(items[position])
                holder.binding.apply {
                    itemList.setOnClickListener {
                        idSelected = currentItem.idItem
                        callback.invoke(currentItem.idItem)
                    }
                }
            }
        }
    }

    override fun getItemCount() = items.size

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

                root.context.apply {
                    txtData.text = getString(R.string.data, service.date.toString())
                    txtPrice.text = getString(R.string.preco, service.price.toString())
                }

                Picasso.get().load(service.image)
                    .placeholder(R.drawable.no_photo)
                    .error(R.drawable.no_photo)
                    .into(imgItemList)
            }
        }

    }
}
