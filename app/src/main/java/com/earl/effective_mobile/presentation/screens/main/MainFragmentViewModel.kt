package com.earl.effective_mobile.presentation.screens.main

import androidx.lifecycle.*
import com.earl.domain.mappers.BestSellerListDomainToPresentationMapper
import com.earl.domain.mappers.HomeStoreListDomainToPresentationMapper
import com.earl.domain.models.BestSellerListDomain
import com.earl.domain.models.HomeStoreListDomain
import com.earl.effective_mobile.presentation.models.BestSellerListPresentation
import com.earl.effective_mobile.presentation.models.BestSellerPresentation
import com.earl.effective_mobile.presentation.models.HomeStoreListPresentation
import com.earl.effective_mobile.presentation.models.HomeStorePresentation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainFragmentViewModel(
    private val interactor: com.earl.domain.Interactor,
    private val homeStoreListDomainToPresentationMapper: HomeStoreListDomainToPresentationMapper,
    private val bestSellerListDomainToPresentationMapper: BestSellerListDomainToPresentationMapper
) : ViewModel() {

    private val homeStoreListLiveData = MutableLiveData<List<HomeStorePresentation>>()
    private val bestSellerListLivedata = MutableLiveData<List<BestSellerPresentation>>()

    private val basketItemsListSizeFlow: MutableStateFlow<Int> = MutableStateFlow(0)
    val _basketItemsListSizeFlow = basketItemsListSizeFlow.asStateFlow()

    fun fetchHomeStoreList() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.fetchHomeStoreList<HomeStoreListDomain>()
                .map<HomeStoreListPresentation>(homeStoreListDomainToPresentationMapper)
                .list()
            withContext(Dispatchers.Main) {
                homeStoreListLiveData.value = list
            }
        }
    }

    fun fetchBestSellerList() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = interactor.fetchBestSellerList<BestSellerListDomain>()
                .map<BestSellerListPresentation>(bestSellerListDomainToPresentationMapper)
                .list()
            withContext(Dispatchers.Main) {
                bestSellerListLivedata.value = list
            }
        }
    }

    fun fetchBasketItemsListSize() {
        viewModelScope.launch(Dispatchers.IO) {
            val size = interactor.fetchBasketItemsListSize<Int>()
            withContext(Dispatchers.Main) {
                if (size >= 1) {
                    basketItemsListSizeFlow.value = size
                }
            }
        }
    }

    fun observeBestSellerLiveData(owner: LifecycleOwner, observer: Observer<List<BestSellerPresentation>>) {
        bestSellerListLivedata.observe(owner, observer)
    }

    fun observeHomeStoreListLiveData(owner: LifecycleOwner, observer: Observer<List<HomeStorePresentation>>) {
        homeStoreListLiveData.observe(owner, observer)
    }
}