package com.earl.effective_mobile.presentation.screens.productDetails.main

import androidx.lifecycle.*
import com.earl.domain.mappers.ProductDetailsDomainToUiMapper
import com.earl.domain.models.ProductDetailsDomain
import com.earl.effective_mobile.presentation.models.ProductDetailsUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductDetailsViewModel(
    private val interactor: com.earl.domain.Interactor,
    private val productDetailsDomainToUiMapper: ProductDetailsDomainToUiMapper<ProductDetailsUi>
) : ViewModel() {

    private val productDetailsImagesLiveData = MutableLiveData<List<String>>()
    private val productDetailsLiveData = MutableLiveData<ProductDetailsUi>()


    fun fetchProductDetails() {
        viewModelScope.launch(Dispatchers.IO) {
            val details = interactor.fetchProductDetails<ProductDetailsDomain>().map(productDetailsDomainToUiMapper)
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