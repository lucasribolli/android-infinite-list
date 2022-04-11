package com.lucasribolli.infinitelist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.lucasribolli.infinitelist.adapter.ListAdapter
import com.lucasribolli.infinitelist.database.AppDatabase
import com.lucasribolli.infinitelist.database.StoredObject
import com.lucasribolli.infinitelist.database.VMFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViewModel()
        insertDummyDataInDb()
        setAdapter()
        observePagedData()
    }

    private fun observePagedData() {
        lifecycleScope.launch {
            viewModel.items.collectLatest { data ->
                adapter.submitData(data)
            }
        }
    }

    private fun setViewModel() {
        viewModel = ViewModelProvider(
            viewModelStore,
            VMFactory(application)
        )[MainViewModel::class.java]
    }

    private fun setAdapter() {
        adapter = ListAdapter()
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
    }

    private fun insertDummyDataInDb() {
        viewModel.insertDummyDataInDB()
    }
}