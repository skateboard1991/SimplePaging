package com.skateboard.newpagingdemo

import androidx.lifecycle.MutableLiveData


class PagedDataSource(val pageDataState: MutableLiveData<Int>) : BaseDataSource<Int, String>(pageDataState) {


    override fun onLoadInitial(params: LoadInitialParams<Int>, callback: StatusLoadInitialCallback<Int, String>) {
        val result = loadData(0)
        callback.onResult(result, null, 1)
    }

    override fun onLoadAfter(params: LoadParams<Int>, callback: StatusLoadCallback<Int, String>) {
        println("key is ${params.key} after")
        val result = loadData(params.key)
        if (params.key <= 3) {
            callback.onResult(result, params.key + 1)
        } else {
            callback.onError()
        }
    }

    override fun onLoadBefore(params: LoadParams<Int>, callback: StatusLoadCallback<Int, String>) {

    }

    fun loadData(index: Int): List<String> {

        val result = mutableListOf<String>()
        for (i in 0..50) {

            result.add("item is $i")
        }
        return result
    }
}