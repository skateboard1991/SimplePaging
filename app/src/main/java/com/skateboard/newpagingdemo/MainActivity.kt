package com.skateboard.newpagingdemo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)

        refreshLayout.isRefreshing = true

        refreshLayout.setOnRefreshListener {

            refreshLayout.isRefreshing = true
            viewModel.listing.refresh?.invoke()
        }

        val adapter = PagedAdapter(viewModel.listing.retry)
        dataRL.adapter = adapter
        viewModel.listing.onStateListener = object : SimpleOnStateListener<String>() {

            override fun onPagedListLoaded(pagedList: PagedList<String>) {
                adapter.submitList(pagedList)
                adapter.updateState(LoadingDataState.LOADED)
                refreshLayout.isRefreshing=false
            }

            override fun onDataLoading() {
                super.onDataLoading()
                adapter.updateState(LoadingDataState.LOADING)
            }

            override fun onDataLoaded() {
                super.onDataLoaded()
                adapter.updateState(LoadingDataState.LOADED)
                refreshLayout.isRefreshing=false
            }

            override fun onDataError() {
                super.onDataError()
                adapter.updateState(LoadingDataState.ERROR)
                refreshLayout.isRefreshing=false
            }

            override fun onPagingBottom() {
                Toast.makeText(this@MainActivity, "at bottom", Toast.LENGTH_SHORT).show()
            }

            override fun onPagingTop() {
                Toast.makeText(this@MainActivity, "at top", Toast.LENGTH_SHORT).show()
            }

            override fun onPagingInitZero() {
                super.onPagingInitZero()
                refreshLayout.isRefreshing = false
            }
        }

        viewModel.listing.observe(this)



    }
}
