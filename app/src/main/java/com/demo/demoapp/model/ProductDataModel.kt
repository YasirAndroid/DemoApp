package com.demo.demoapp.model


import com.google.gson.annotations.SerializedName

data class ProductDataModel(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("msg")
    val msg: String,
    @SerializedName("result")
    val result: Int
) {
    data class Data(
        @SerializedName("itemsPerPage")
        val itemsPerPage: Int,
        @SerializedName("list")
        val list: ArrayList<DataList>,
        @SerializedName("startIndex")
        val startIndex: Int,
        @SerializedName("totalItems")
        val totalItems: Int
    ) {
        data class DataList(
            @SerializedName("age")
            val age: Int,
            @SerializedName("history")
            val history: String,
            @SerializedName("_id")
            val id: String,
            @SerializedName("isCoin")
            val isCoin: Boolean,
            @SerializedName("isGraded")
            val isGraded: Boolean,
            @SerializedName("isSold")
            val isSold: Boolean,
            @SerializedName("name")
            val name: String,
            @SerializedName("pictures")
            val pictures: Pictures,
            @SerializedName("price")
            val price: Int,
            @SerializedName("tags")
            val tags: List<String>,
            @SerializedName("year")
            val year: Int
        ) {
            data class Pictures(
                @SerializedName("back")
                val back: Back,
                @SerializedName("front")
                val front: Front
            ) {
                data class Back(
                    @SerializedName("key")
                    val key: String,
                    @SerializedName("sizeInMegaByte")
                    val sizeInMegaByte: Double,
                    @SerializedName("url")
                    val url: String
                )

                data class Front(
                    @SerializedName("key")
                    val key: String,
                    @SerializedName("sizeInMegaByte")
                    val sizeInMegaByte: Double,
                    @SerializedName("url")
                    val url: String
                )
            }
        }
    }
}