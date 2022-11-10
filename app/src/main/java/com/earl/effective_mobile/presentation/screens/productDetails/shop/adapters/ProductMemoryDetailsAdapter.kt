package com.earl.effective_mobile.presentation.screens.productDetails.shop.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.earl.effective_mobile.R
import com.earl.effective_mobile.databinding.PrdctSsdRecyclerItemBinding

interface OnMemoryClickListener {

    fun onMemoryClick(item: String)
}

class ProductMemoryDetailsAdapter(
    private val clickListener: OnMemoryClickListener
) : ListAdapter<String, ProductMemoryDetailsAdapter.ItemViewHolder>(Diff) {

    private var selectedItem: String? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            PrdctSsdRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            if (selectedItem == item) {
                clickListener.onMemoryClick(holder.changeNotSelectedBackground(item))
                selectedItem = null
            } else {
                clickListener.onMemoryClick(holder.changeSelectedBackground(item))
            }
        }
    }

    inner class ItemViewHolder(private val binding: PrdctSsdRecyclerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val context = binding.layout.context

        fun changeNotSelectedBackground(item: String) : String {
            binding.sdd.setTextColor(ContextCompat.getColor(context, R.color.prod_dtls_color))
            binding.layout.setBackgroundResource(R.drawable.prdct_recycler_item_backround)
            return item
        }

        fun changeSelectedBackground(item: String): String {
            if (item != selectedItem) {
                binding.sdd.setTextColor(ContextCompat.getColor(context, R.color.white))
                binding.layout.setBackgroundResource(R.drawable.done_btn_background)
                selectedItem = item
            }
            return item
        }
        fun bind(item: String) {
            binding.sdd.text = item
        }
    }

    companion object Diff : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String) = oldItem == newItem

        override fun areContentsTheSame(oldItem: String, newItem: String) =
            oldItem.equals(newItem)
    }
}
