package com.demo.demoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.demoapp.R
import com.demo.demoapp.model.ProductDataModel

class RecyclerAdapter(var data: ArrayList<ProductDataModel.Data.DataList>) :
    RecyclerView.Adapter<RecyclerAdapter.dataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): dataViewHolder {
        val view1: View =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_layout, parent, false)
        return dataViewHolder(view1)
    }

    override fun onBindViewHolder(holder: dataViewHolder, position: Int) {

        holder.name.text = data[position].name
        if (data[position].pictures!=null && data[position].pictures.front != null && data[position].pictures.front.url != null ) {
            Glide
                .with(holder.itemView.context)
                .load(data[position].pictures.front.url)
                .centerCrop()
                .into(holder.image)
        }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class dataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById(R.id.image_item) as ImageView
        val name = itemView.findViewById(R.id.name_item) as TextView

    }
}