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
        val adapter = PagedAdapter()
        dataRL.adapter = adapter
        viewModel.listing.onStateListener = object : SimpleOnStateListener<String>() {

            override fun onPagedListLoaded(pagedList: PagedList<String>) {
                adapter.submitList(pagedList)
            }

            override fun onDataLoading() {
                super.onDataLoading()
            }

            override fun onDataLoaded() {
                super.onDataLoaded()
            }

            override fun onDataError() {
                super.onDataError()
            }

            override fun onPagingBottom() {
               Toast.makeText(this@MainActivity,"at bottom",Toast.LENGTH_SHORT).show()
            }

            override fun onPagingTop() {
                Toast.makeText(this@MainActivity,"at top",Toast.LENGTH_SHORT).show()
            }

            override fun onPagingInitZero() {
                super.onPagingInitZero()
            }
        }

        viewModel.listing.observe(this)

    }
}
