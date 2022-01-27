package com.fueled

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fueled.data.DataRepository

/**
 * Created by Mohd Irfan on 26/1/22.
 */
class ViewModelFactory(val mDataRepository:DataRepository) : ViewModelProvider.Factory {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(mDataRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}