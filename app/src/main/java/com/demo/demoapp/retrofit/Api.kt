package com.demo.demoapp.retrofit

import com.demo.demoapp.model.ProductDataModel
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("/coinlist")
    fun getProductDetails() : Call<ProductDataModel>

}