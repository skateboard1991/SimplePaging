package com.skateboard.newpagingdemo

import androidx.lifecycle.MutableLiveData


class PageDataSourceFactory(dataState: MutableLiveData<Int>) : BaseDataSourceFactory<Int, String>(dataState) {

    override fun generateDataSource(): BaseDataSource<Int, String> {
        return PagedDataSource(loadingDataState)
    }
}