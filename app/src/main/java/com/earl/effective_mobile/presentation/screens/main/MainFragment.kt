package com.earl.effective_mobile.presentation.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.earl.effective_mobile.R
import com.earl.effective_mobile.core.BaseFragment
import com.earl.effective_mobile.databinding.FragmentMainBinding
import com.earl.effective_mobile.presentation.models.BestSellerPresentation
import com.earl.effective_mobile.presentation.models.ProductCategory
import com.earl.effective_mobile.presentation.screens.main.recyclerAdapters.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding>(), BestSellerClickListener, OnCategoryClickListener {

    private val viewModel by viewModel<MainFragmentViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentMainBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bottomSheet()
        homeStoreRecycler()
        bestSellerRecycler()
        productCategoryRecycler()
        initBasketItemListSize()
        initSpinners()
        binding.bag.setOnClickListener { navigator.cartFragment() }
    }

    private fun homeStoreRecycler() {
        viewModel.fetchHomeStoreList()
        val adapter = HomeStoreRecyclerAdapter()
        binding.hotSalesRecycler.adapter = adapter
        binding.hotSalesRecycler.recycledViewPool.setMaxRecycledViews(
            R.layout.hotsales_recycler_item,
            adapter.itemCount
        )
        viewModel.observeHomeStoreListLiveData(this) {
            adapter.submitList(it)
        }
    }

    private fun bestSellerRecycler() {
        viewModel.fetchBestSellerList()
        val adapter = BestSellerRecyclerAdapter(this)
        binding.bestSellersRecycler.adapter = adapter
        viewModel.observeBestSellerLiveData(this) {
            adapter.submitList(it)
        }
    }

    private fun productCategoryRecycler() {

        val adapter = ProductCategoryRecyclerAdapter(this)
        binding.category.adapter = adapter

        val productCategoriesList = listOf(
            ProductCategory.Base(getString(R.string.phoness), R.drawable._hone, true),
            ProductCategory.Base(getString(R.string.comp), R.drawable.computer, false),
            ProductCategory.Base(getString(R.string.health), R.drawable.vectorheart, false),
            ProductCategory.Base(getString(R.string.boks), R.drawable.books, false),
            ProductCategory.Base(getString(R.string.anoterbooks), R.drawable.books, false),
        )
        adapter.submitList(productCategoriesList)
    }

    private fun bottomSheet() {

        val behavior = BottomSheetBehavior.from(binding.bottomSheetLayout)
        behavior.peekHeight = 60.pxToDp()
        behavior.state = BottomSheetBehavior.STATE_COLLAPSED

        val sheet = BottomSheetBehavior.from(binding.bottomSheetLayout)

        binding.filter.setOnClickListener {
            if (sheet.state == BottomSheetBehavior.STATE_EXPANDED) {
                sheet.state = BottomSheetBehavior.STATE_COLLAPSED
            } else if (sheet.state == BottomSheetBehavior.STATE_COLLAPSED) {
                sheet.state = BottomSheetBehavior.STATE_EXPANDED
            }
        }

        binding.backBtn.setOnClickListener {
            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        binding.doneBtn.setOnClickListener {
            sheet.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        behavior.addBottomSheetCallback(
            object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {}
                override fun onSlide(bottomSheet: View, slideOffset: Float) {
                    if (slideOffset > 0) {
                        binding.collapsed.alpha =  1 - 2 * slideOffset
                    }
                    if (slideOffset > 0.5) {
                        binding.collapsed.visibility = View.GONE
                    }
                    if (slideOffset < 0.5 && binding.expanded.visibility == View.VISIBLE) {
                        binding.collapsed.visibility = View.VISIBLE
                    }
                }
            })
    }

    private fun initBasketItemListSize() {
        viewModel.fetchBasketItemsListSize()
        lifecycleScope.launchWhenCreated {
            viewModel._basketItemsListSizeFlow.onEach { count ->
                if (count != 0) {
                    binding.itemsCount.isVisible = true
                    binding.itemsCount.text = count.toString()
                } else {
                    binding.itemsCount.isVisible = false
                }
            }.collect()
        }
    }

    private fun initSpinners() {
        val brandSpinner = binding.brandSpinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.brands_spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            brandSpinner.adapter = adapter
        }

        val priceSpinner = binding.priceSpinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.price_spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            priceSpinner.adapter = adapter
        }

        val sizeSpinner = binding.sizeSpinner
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.size_spinner,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            sizeSpinner.adapter = adapter
        }
    }

    override fun onBestSellerCLick(item: BestSellerPresentation) {
        navigator.detailsFragment()
    }

    override fun onCategoryClick(item: ProductCategory) {
        item.clickReact()
    }

    private fun Int.pxToDp() = (this * resources.displayMetrics.density).toInt()

    companion object {

        fun newInstance() = MainFragment()
    }
}