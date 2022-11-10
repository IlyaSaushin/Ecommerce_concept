package com.earl.effective_mobile.presentation.screens.basket.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.earl.effective_mobile.databinding.CartRecyclerItemBinding
import com.earl.effective_mobile.presentation.models.BasketItemUi

class BasketRecyclerAdapter : ListAdapter<BasketItemUi, BasketRecyclerAdapter.ItemViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CartRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ItemViewHolder(private val binding: CartRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BasketItemUi) {
            item.details(
                binding.prodName,
                binding.prodImage,
                binding.prodPrice
            )
        }
    }

    companion object Diff : DiffUtil.ItemCallback<BasketItemUi>() {

        override fun areItemsTheSame(oldItem: BasketItemUi, newItem: BasketItemUi) = oldItem.same(newItem)

        override fun areContentsTheSame(oldItem: BasketItemUi, newItem: BasketItemUi) = oldItem.equals(newItem)
    }
}