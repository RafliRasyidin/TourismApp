package com.rasyidin.tourismapp.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rasyidin.tourismapp.R
import com.rasyidin.tourismapp.core.domain.model.Tourism
import com.rasyidin.tourismapp.databinding.ItemListTourismBinding

class TourismAdapter : RecyclerView.Adapter<TourismAdapter.ListViewHolder>() {

    private var listData = ArrayList<Tourism>()
    var onItemClick: ((Tourism) -> Unit)? = null

    fun setData(newListData: List<Tourism>?) {
        if (newListData.isNullOrEmpty()) return
        listData.clear()
        listData.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_tourism, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListTourismBinding.bind(itemView)
        fun bind(data: Tourism) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(data.image)
                    .into(ivItemImage)
                tvItemSubtitle.text = data.address
                tvItemTitle.text = data.name
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}