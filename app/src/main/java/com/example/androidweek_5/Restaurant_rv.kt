package com.example.androidweek_5
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import android.widget.Switch
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidweek_5.R
import com.example.androidweek_5.databinding.RvLayoutBinding


class Restaurant_rv : Fragment(){

    lateinit var binding: RvLayoutBinding
    lateinit var adapter: RestaurantAdapter
    lateinit var adapter_grid: RestaurantAdapterGrid
    //viewmodel
    lateinit var viewModel: RestaurantVM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.rv_layout, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[RestaurantVM::class.java]

        //viewModel.loadData()
        setUpRecyclerView()
        viewModel.loadData()
        binding.menuswitch.setOnClickListener{view ->
            var checked = (view as Switch).isChecked
            if (!checked) {
                setUpRecyclerView()
                viewModel.loadData()
            } else {
                setUpRecyclerViewGrid()
                viewModel.loadData()
            }

        }
        binding.mvtoProfiles.setOnClickListener {
            val controller = findNavController()
            controller.navigate(R.id.restaurant_rv_to_profileActivity)
        }
        setUpButtonLoad()
        registerDataEvent()
        registerLoadingView()

    }

    private fun setUpRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = RestaurantAdapter()
        adapter_grid = RestaurantAdapterGrid()
        binding.recyclerView.adapter = adapter
    }
    private fun setUpRecyclerViewGrid() {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        adapter = RestaurantAdapter()
        adapter_grid = RestaurantAdapterGrid()
        binding.recyclerView.adapter = adapter_grid
    }

    private fun setUpButtonLoad() {
        binding.btnLoad.setOnClickListener {
            viewModel.loadData()
        }
    }

    private fun registerDataEvent() {
        viewModel.listOfIdol.observe(viewLifecycleOwner, Observer { data ->
            run {
                adapter.setData(data)
                adapter_grid.setData(data)
            }
        })
    }

    private fun registerLoadingView() {
        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            run {
                binding.progressBar.visibility =
                    if (isLoading) View.VISIBLE else
                        View.INVISIBLE
            }
        }
    }
}