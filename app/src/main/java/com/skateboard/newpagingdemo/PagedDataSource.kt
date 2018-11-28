package com.skateboard.newpagingdemo

import androidx.lifecycle.MutableLiveData


class PagedDataSource(val pageDataState:MutableLiveData<Int>): BaseDataSource<Int, String>(pageDataState) {
    override fun onLoadInitial(params: LoadInitialParams<Int>, callback: StatusLoadInitialCallback<Int, String>) {
        val result = loadData()
        callback.onResult(result, 1, 3)
    }

    override fun onLoadAfter(params: LoadParams<Int>, callback: StatusLoadCallback<Int, String>) {
        println("key is ${params.key} after")
        val result = loadData()
        if (params.key <= 5) {
            callback.onResult(result, params.key + 1)
        } else {
            callback.onResult(mutableListOf(), null)
        }
    }

    override fun onLoadBefore(params: LoadParams<Int>, callback: StatusLoadCallback<Int, String>) {
        println("key is ${params.key} before")
        val data = loadData()
        if(params.key<-2)
        {
            callback.onResult(mutableListOf(), params.key - 1)
        }else
        {
            callback.onResult(data, params.key - 1)
        }

    }

    fun loadData(): List<String> {

        Thread.sleep(500)
        val result = mutableListOf<String>()
        for (i in 0..50) {

            result.add("item is $i")
        }
        return result
    }
}