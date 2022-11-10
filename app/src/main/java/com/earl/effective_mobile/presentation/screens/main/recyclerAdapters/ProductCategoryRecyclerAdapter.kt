package com.earl.effective_mobile.presentation.screens.main.recyclerAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.earl.effective_mobile.R
import com.earl.effective_mobile.databinding.CategoryRecyclerItemBinding
import com.earl.effective_mobile.presentation.models.ProductCategory

interface OnCategoryClickListener {
    fun onCategoryClick(item: ProductCategory)
}

class ProductCategoryRecyclerAdapter(
    private val clickListener: OnCategoryClickListener
) : ListAdapter<ProductCategory, ProductCategoryRecyclerAdapter.ItemViewHolder>(Diff) {

    private var selected: ProductCategory? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = CategoryRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.itemView.setOnClickListener {
            clickListener.onCategoryClick(item)
            notifyDataSetChanged()
        }
    }

    inner class ItemViewHolder(private val binding: CategoryRecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {

        private val context = binding.categoryName.context

        fun bind(item: ProductCategory) {
            item.setDetails(
                binding.categoryName,
                binding.image
            )
            if (selected != item) {
                if (item.isSelected()) {
                    binding.categoryName.setTextColor(ContextCompat.getColor(context, R.color.orange))
                    binding.layout.setBackgroundResource(R.drawable.category_recycler_selected_item_background)
                    DrawableCompat.setTint(binding.image.drawable, ContextCompat.getColor(context, R.color.white))
                    selected?.clickReact()
                    selected = item
                } else {
                    binding.categoryName.setTextColor(ContextCompat.getColor(context, R.color.textColor))
                    binding.layout.setBackgroundResource(R.drawable.category_recycler_not_selected_item_background)
                    DrawableCompat.setTint(binding.image.drawable, ContextCompat.getColor(context, R.color.icon_color))
                }
            } else {
                binding.categoryName.setTextColor(ContextCompat.getColor(context, R.color.textColor))
                binding.layout.setBackgroundResource(R.drawable.category_recycler_not_selected_item_background)
                DrawableCompat.setTint(binding.image.drawable, ContextCompat.getColor(context, R.color.icon_color))
            }
        }
    }

    companion object Diff : DiffUtil.ItemCallback<ProductCategory>() {

        override fun areItemsTheSame(oldItem: ProductCategory, newItem: ProductCategory) = oldItem.same(newItem)

        override fun areContentsTheSame(oldItem: ProductCategory, newItem: ProductCategory) = oldItem.equals(newItem)
    }
}