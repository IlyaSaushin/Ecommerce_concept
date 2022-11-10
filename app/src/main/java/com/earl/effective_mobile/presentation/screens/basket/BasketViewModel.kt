package com.earl.effective_mobile.presentation.screens.basket

import android.util.Log
import androidx.lifecycle.*
import com.earl.domain.mappers.BasketDomainToUiMapper
import com.earl.domain.models.BasketDomain
import com.earl.effective_mobile.presentation.models.BasketItemUi
import com.earl.effective_mobile.presentation.models.BasketUi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BasketViewModel(
    private val interactor: com.earl.domain.Interactor,
    private val basketDomainToUiMapper: BasketDomainToUiMapper<BasketUi>
) : ViewModel() {

    private val basketItemsLiveData = MutableLiveData<List<BasketItemUi>>()
    private val basketLiveData = MutableLiveData<BasketUi>()

    fun fetchBasket() {
        viewModelScope.launch(Dispatchers.IO) {
            val basket = interactor.fetchBasket<BasketDomain>().map(basketDomainToUiMapper)
            withContext(Dispatchers.Main) {
                basketItemsLiveData.value = basket.baskets()
                basketLiveData.value = basket
                Log.d("tag", "fetchBasket: ${basketItemsLiveData.value}")
            }
        }
    }

    fun observeBasketLiveData(owner: LifecycleOwner, observer: Observer<BasketUi>) {
        basketLiveData.observe(owner, observer)
    }

    fun observeBasketItemsLiveData(owner: LifecycleOwner, observer: Observer<List<BasketItemUi>>) {
        basketItemsLiveData.observe(owner, observer)
    }
}