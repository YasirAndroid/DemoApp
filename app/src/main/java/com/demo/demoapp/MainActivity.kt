package com.demo.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.demo.demoapp.adapter.RecyclerAdapter
import com.demo.demoapp.databinding.ActivityMainBinding
import com.demo.demoapp.model.ProductDataModel
import com.demo.demoapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMain.layoutManager = GridLayoutManager(this, 3)
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.data.observe(this){
            binding.rvMain.adapter = RecyclerAdapter(it.data.list)
        }
        viewModel.getProductDetails()
    }
}