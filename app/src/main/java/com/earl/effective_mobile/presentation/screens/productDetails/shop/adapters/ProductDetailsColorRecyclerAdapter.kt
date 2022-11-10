package com.earl.effective_mobile.presentation.screens.productDetails.shop.adapters

import android.graphics.Color
import android.graphics.LightingColorFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.earl.effective_mobile.R
import com.earl.effective_mobile.databinding.ProducrColorsRecyclerItemBinding

interface OnColorDetailsClickListener {

    fun onColorDetailsClick(item: ImageView)
}

class ProductDetailsColorRecyclerAdapter(
    private val clickListener: OnColorDetailsClickListener
) : ListAdapter<String, ProductDetailsColorRecyclerAdapter.ItemViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ProducrColorsRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener.onColorDetailsClick(holder.selectedImage())
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(private val binding: ProducrColorsRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.layout.context

        fun selectedImage() = binding.selectedIcon

        fun bind(color: String) {
            val dr = AppCompatResources.getDrawable(context, R.drawable.prod_color_recycler_item_background)
            dr?.colorFilter = LightingColorFilter(Color.parseColor(color), Color.parseColor(color))
            binding.layout.background = dr
            binding.selectedIcon.setImageResource(R.drawable.nike)
        }
    }

    companion object Diff : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) = oldItem.equals(newItem)
    }
}