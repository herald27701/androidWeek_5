package com.example.androidweek_4
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import android.widget.ImageButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidweek_4.databinding.RvLayoutBinding
class Restaurant_rv : AppCompatActivity(){

    lateinit var binding: RvLayoutBinding
    lateinit var adapter: RestaurantAdapter
    //viewmodel
    lateinit var viewModel: RestaurantVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.rv_layout)
        viewModel = ViewModelProvider(this)[RestaurantVM::class.java]

        setUpRecyclerView()
        setUpButtonLoad()

        registerDataEvent()
        registerLoadingView()

    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this);

        adapter = RestaurantAdapter()
        binding.recyclerView.adapter = adapter
    }


    private fun setUpButtonLoad() {
        binding.btnLoad.setOnClickListener {
            viewModel.loadData()
        }
    }

    private fun registerDataEvent() {
        viewModel.listOfIdol.observe(this, Observer { data ->
            run {
                adapter.setData(data)
            }
        })
    }

    private fun registerLoadingView() {
        viewModel.isLoading.observe(this) { isLoading ->
            run {
                binding.progressBar.visibility =
                    if (isLoading) View.VISIBLE else
                        View.INVISIBLE
            }
        }
    }
}