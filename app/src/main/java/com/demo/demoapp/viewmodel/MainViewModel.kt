package com.demo.demoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.demoapp.model.ProductDataModel
import com.demo.demoapp.repo.mainRepo

class MainViewModel : ViewModel() {

    val data = MutableLiveData<ProductDataModel>()

    val repo = mainRepo

    fun getProductDetails(){
        repo.getProductData().observeForever {
            data.value = it
        }
    }
}