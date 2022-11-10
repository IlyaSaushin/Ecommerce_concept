package com.earl.effective_mobile.presentation.screens.productDetails.shop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import com.earl.effective_mobile.core.BaseFragment
import com.earl.effective_mobile.databinding.FragmentShopDetailsBinding
import com.earl.effective_mobile.presentation.models.ProductDetailsUi
import com.earl.effective_mobile.presentation.screens.productDetails.shop.adapters.OnColorDetailsClickListener
import com.earl.effective_mobile.presentation.screens.productDetails.shop.adapters.OnMemoryClickListener
import com.earl.effective_mobile.presentation.screens.productDetails.shop.adapters.ProductDetailsColorRecyclerAdapter
import com.earl.effective_mobile.presentation.screens.productDetails.shop.adapters.ProductMemoryDetailsAdapter

class ShopDetailsFragment(
    private val item: ProductDetailsUi
) : BaseFragment<FragmentShopDetailsBinding>(), OnColorDetailsClickListener, OnMemoryClickListener {

    private var selectedColor: ImageView? = null

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentShopDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDetails()
        memoryAdapter()
        colorsRecycler()
    }

    private fun initDetails() {
        item.setShopDetails(
            binding.addToCart,
            binding.procDescr,
            binding.cameraDescr,
            binding.ramDescr,
            binding.ssdDescr
        )
    }

    private fun colorsRecycler() {
        val adapter = ProductDetailsColorRecyclerAdapter(this)
        binding.prodColorRecycler.adapter = adapter
        adapter.submitList(item.colors())
    }

    private fun memoryAdapter() {
        val adapter = ProductMemoryDetailsAdapter(this)
        binding.prodSddRecycler.adapter = adapter
        adapter.submitList(item.mamory())
    }

    override fun onColorDetailsClick(item: ImageView) {
        if (selectedColor != item) {
            item.isVisible = true
            selectedColor?.isVisible = false
            selectedColor = item
        }
    }

    override fun onMemoryClick(item: String) {

    }

    companion object {
        fun newInstance(item: ProductDetailsUi) = ShopDetailsFragment(item)
    }
}
