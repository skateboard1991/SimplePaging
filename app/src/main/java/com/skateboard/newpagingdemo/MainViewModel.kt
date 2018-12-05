package com.skateboard.newpagingdemo


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class MainViewModel : ViewModel() {




    val dataFactory = PageDataSourceFactory(MutableLiveData<Int>())
//    val livePagedList=LivePagedListBuilder(dataFactory,30).build()
//    val listing=Listing<String>(livePagedList,)
    val listing = dataFactory.generateListing()

}