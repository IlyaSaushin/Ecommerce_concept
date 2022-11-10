package com.earl.effective_mobile.presentation.screens.main.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.earl.effective_mobile.databinding.BestsellersRecyclerItemBinding
import com.earl.effective_mobile.presentation.models.BestSellerPresentation

interface BestSellerClickListener {
    fun onBestSellerCLick(item: BestSellerPresentation)
}

class BestSellerRecyclerAdapter(
    private val clickListener: BestSellerClickListener
) : ListAdapter<BestSellerPresentation, BestSellerRecyclerAdapter.ItemViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = BestsellersRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener.onBestSellerCLick(item)
        }
    }

    inner class ItemViewHolder(private val binding: BestsellersRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: BestSellerPresentation) {
            item.details(
                binding.phoneImage,
                binding.currentPrice,
                binding.lastPrice,
                binding.phoneName
            )
            if (!item.isFavorite()) {
                binding.favIcon.isVisible = false
                binding.notFavIcon.isVisible = true
            } else {
                binding.favIcon.isVisible = true
                binding.notFavIcon.isVisible = false
            }
        }
    }

    companion object Diff : DiffUtil.ItemCallback<BestSellerPresentation>() {

        override fun areItemsTheSame(oldItem: BestSellerPresentation, newItem: BestSellerPresentation) = oldItem.same(newItem)

        override fun areContentsTheSame(oldItem: BestSellerPresentation, newItem: BestSellerPresentation) = oldItem.equals(newItem)
    }
}