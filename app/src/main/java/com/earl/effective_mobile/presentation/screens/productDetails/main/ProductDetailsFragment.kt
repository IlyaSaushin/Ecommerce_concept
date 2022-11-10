package com.earl.effective_mobile.presentation.screens.productDetails.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.earl.effective_mobile.R
import com.earl.effective_mobile.databinding.FragmentProductDetailsBinding
import com.earl.effective_mobile.presentation.BaseFragment
import com.earl.effective_mobile.presentation.models.ProductDetailsUi
import com.earl.effective_mobile.presentation.screens.productDetails.main.recyclerAdapters.CenterDecoration
import com.earl.effective_mobile.presentation.screens.productDetails.main.recyclerAdapters.CenterSnapHelper
import com.earl.effective_mobile.presentation.screens.productDetails.main.recyclerAdapters.ProductDetailsImagesRecyclerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>() {

    private val viewModel by viewModel<ProductDetailsViewModel>()
    private val snapHelper = CenterSnapHelper()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentProductDetailsBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchProductDetails()
        imagesRecycler()
        initProductInfo()
        binding.backArrowBtn.setOnClickListener {
            navigator.back()
        }
        binding.toCartBtn.setOnClickListener {
            navigator.cartFragment()
        }
    }

    private fun initProductInfo() {
        viewModel.observeProductDetailsLD(this) {
            it.setMainDetails(
                binding.productName,
                binding.ratingBar,
                binding.addToFavBtn
            )
            initViewPager(it)
        }
    }

    private fun imagesRecycler() {

        val adapter = ProductDetailsImagesRecyclerAdapter()
        val layoutManager = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.productDetailsImagesRecycler.addItemDecoration(CenterDecoration(0))
        snapHelper.attachToRecyclerView(binding.productDetailsImagesRecycler)

        binding.productDetailsImagesRecycler.adapter = adapter
        binding.productDetailsImagesRecycler.layoutManager = layoutManager
        viewModel.observeProductDetailsImagesLD(this) {
            adapter.submitList(it)
        }

        binding.productDetailsImagesRecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                recyclerView.post {
                    selectMiddleItem(layoutManager, recyclerView)
                }
            }
        })
    }

    private fun selectMiddleItem(manager: LinearLayoutManager, recyclerView: RecyclerView) {

        val firstVisibleIndex = manager.findFirstVisibleItemPosition()
        val lastVisibleIndex = manager.findLastVisibleItemPosition()
        val visibleIndexes = listOf(firstVisibleIndex..lastVisibleIndex).flatten()

        for (k in visibleIndexes) {
            val vh = recyclerView.findViewHolderForLayoutPosition(k)
            if (vh?.itemView == null) {
                continue
            }
            val location = IntArray(2)
            vh.itemView.getLocationOnScreen(location)
            val x = location[0]
            val halfWidth = vh.itemView.width * .5
            val rightSide = x + halfWidth
            val leftSide = x - halfWidth
            val isInMiddle = manager.width * .5 in leftSide..rightSide
            if (isInMiddle) {

                val mid = manager.width * 5
                val d1 = 0.9f * mid
                for (i in 0 until manager.childCount) {
                    val child = manager.getChildAt(i)
                    val childMid = (manager.getDecoratedRight(child!!) + manager.getDecoratedLeft(child)) / 0.2f
                    val d = Math.min(d1, Math.abs(mid - childMid))
                    Log.d("tag", "selectMiddleItem: d ->  $d")
                    val scale = 1f - 0.15f * d / d1
                    Log.d("tag", "selectMiddleItem: scale ->  $scale")
                    child.scaleX = scale
                    child.scaleY = scale
                    child.elevation = 40f
                }
                return
            }
        }
    }

    private fun initViewPager(item: ProductDetailsUi) {
        binding.detailsViewPager.adapter = ViewPagerDetailsAdapter(this, item)
        binding.productDetailsTabs.tabIconTint = null
        TabLayoutMediator(binding.productDetailsTabs, binding.detailsViewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = getString(R.string.shop)
                }
                1 -> {
                    tab.text = getString(R.string.details)
                }
                2 -> {
                    tab.text = getString(R.string.features)
                }
            }
        }.attach()
    }

    companion object {

        fun newInstance() = ProductDetailsFragment()
    }
}