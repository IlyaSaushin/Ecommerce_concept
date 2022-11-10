package com.earl.effective_mobile.presentation.screens.main.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.earl.effective_mobile.databinding.HotsalesRecyclerItemBinding
import com.earl.effective_mobile.presentation.models.HomeStorePresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeStoreRecyclerAdapter : ListAdapter<HomeStorePresentation, HomeStoreRecyclerAdapter.ItemViewHolder>(Diff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = HotsalesRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ItemViewHolder(private val binding: HotsalesRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: HomeStorePresentation) {
            item.details(
                binding.phoneModel,
                binding.phoneDescription,
                binding.image,
                binding.layout
            )
            if (!item.isNew()) {
                binding.newImage.isVisible = false
            }
        }
    }

    companion object Diff : DiffUtil.ItemCallback<HomeStorePresentation>() {

        override fun areItemsTheSame(oldItem: HomeStorePresentation, newItem: HomeStorePresentation) = oldItem.same(newItem)

        override fun areContentsTheSame(oldItem: HomeStorePresentation, newItem: HomeStorePresentation) = oldItem.equals(newItem)
    }
}