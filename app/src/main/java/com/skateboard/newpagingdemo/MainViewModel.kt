package com.skateboard.newpagingdemo


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel : ViewModel() {


    val dataFactory = PageDataSourceFactory(MutableLiveData<Int>())

    val listing = dataFactory.generateListing()

}