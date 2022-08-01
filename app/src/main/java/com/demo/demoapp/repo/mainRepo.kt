package com.demo.demoapp.repo

import androidx.lifecycle.MutableLiveData
import com.demo.demoapp.model.ProductDataModel
import com.demo.demoapp.retrofit.APIClient
import com.demo.demoapp.retrofit.Api
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.awaitResponse

object mainRepo {

     fun getProductData(): MutableLiveData<ProductDataModel> {
        val data=MutableLiveData<ProductDataModel>()

        val service = APIClient.getInstanse()!!.create(Api::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = service.getProductDetails().awaitResponse()
            withContext(Dispatchers.Main){
                if (response.isSuccessful){
                    data.postValue(response.body())
                }
            }
        }

       // val call = service.getProductDetails()
       // call.enqueue(object : Callback<ProductDataModel> {
       //
       //     override fun onResponse(call: Call<ProductDataModel>, response: Response<ProductDataModel>) {
       //         data.value = response.body()
       //     }
       //
       //     override fun onFailure(call: Call<ProductDataModel>, t: Throwable) {
       //
       //     }
       // })
        return data
    }

}