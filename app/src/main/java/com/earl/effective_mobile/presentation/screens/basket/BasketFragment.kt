package com.earl.effective_mobile.presentation.screens.basket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.earl.effective_mobile.core.BaseFragment
import com.earl.effective_mobile.databinding.FragmentCartBinding
import com.earl.effective_mobile.presentation.screens.basket.recyclerAdapters.BasketRecyclerAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class BasketFragment : BaseFragment<FragmentCartBinding>() {

    private val viewModel by viewModel<BasketViewModel>()

    override fun createViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCartBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchBasket()
        recycler()
        setDetails()
        binding.backArrowBtn.setOnClickListener {
            navigator.back()
        }
    }

    private fun recycler() {
        val adapter = BasketRecyclerAdapter()
        binding.cartRecycler.adapter = adapter
        viewModel.observeBasketItemsLiveData(this) {
            adapter.submitList(it)
        }
    }

    private fun setDetails() {
        viewModel.observeBasketLiveData(this) {
            it.details(
                binding.totalPrice,
                binding.deliveryPrice
            )
        }
    }

    companion object {

        fun newInstance() = BasketFragment()
    }
}