package com.earl.effective_mobile.presentation.screens.productDetails.main

import androidx.lifecycle.*
import com.earl.effective_mobile.domain.Interactor
import com.earl.effective_mobile.domain.mappers.ProductDetailsDomainToUiMapper
import com.earl.effective_mobile.presentation.models.ProductDetailsUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailsViewModel(
    private val interactor: Interactor,
    private val productDetailsDomainToUiMapper: ProductDetailsDomainToUiMapper<ProductDetailsUi>
) : ViewModel() {

    private val productDetailsImagesLiveData = MutableLiveData<List<String>>()
    private val productDetailsLiveData = MutableLiveData<ProductDetailsUi>()


    fun fetchProductDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            val details = interactor.fetchProductDetails().map(productDetailsDomainToUiMapper)
            withContext(Dispatchers.Main) {
                productDetailsImagesLiveData.value = details.image()
                productDetailsLiveData.value = details
            }
        }
    }

    fun observeProductDetailsImagesLD(owner: LifecycleOwner, observer: Observer<List<String>>) {
        productDetailsImagesLiveData.observe(owner, observer)
    }

    fun observeProductDetailsLD(owner: LifecycleOwner, observer: Observer<ProductDetailsUi>) {
        productDetailsLiveData.observe(owner, observer)
    }
}