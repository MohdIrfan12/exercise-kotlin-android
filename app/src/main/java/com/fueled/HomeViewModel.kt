package com.fueled

import androidx.lifecycle.*
import com.fueled.data.DataRepository
import com.fueled.ui.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(val repository: DataRepository) : ViewModel() {

    val responseLiveData = MutableLiveData<List<User>>()

    fun getUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            val list = repository.getUsers(3)
            val users = mutableListOf<User>()
            for (item in list) {
               users.add( User(item.id, item.name, item.commentsAvg))
            }
            withContext(Dispatchers.Main) {
                responseLiveData.postValue(users)
            }
        }
    }
}