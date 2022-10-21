package com.assignement.assignement.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.assignement.assignement.data.api.ApiService
import com.assignement.assignement.data.model.UserDetails

class HomeScreenRepository(private val apiService: ApiService) {

    private val usersLiveData = MutableLiveData<MutableList<UserDetails>>()

    val users : LiveData<MutableList<UserDetails>>
    get() = usersLiveData

    suspend fun getUsers(userCount : Int){
        val result = apiService.getUsers(userCount)
        if(result?.body() != null){
            val response = result.body()
            usersLiveData.postValue(response!!.results)
        }
    }
}