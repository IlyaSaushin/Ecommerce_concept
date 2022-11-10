package com.earl.effective_mobile.presentation.screens.productDetails.main

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.earl.effective_mobile.presentation.models.ProductDetailsUi
import com.earl.effective_mobile.presentation.screens.productDetails.details.ProductFurtherDetails
import com.earl.effective_mobile.presentation.screens.productDetails.features.FeaturesDetailsFragment
import com.earl.effective_mobile.presentation.screens.productDetails.shop.ShopDetailsFragment

class ViewPagerDetailsAdapter(
    fa: Fragment,
    private val item: ProductDetailsUi
) : FragmentStateAdapter(fa) {

    override fun getItemCount() = DETAILS_SCREENS_COUNT

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ShopDetailsFragment.newInstance(item)
            1 -> ProductFurtherDetails.newInstance()
            else -> FeaturesDetailsFragment.newInstance()
        }
    }

    companion object {
        private const val DETAILS_SCREENS_COUNT = 3
    }
}