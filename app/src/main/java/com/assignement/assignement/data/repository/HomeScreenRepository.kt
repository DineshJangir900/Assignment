package com.assignement.assignement.data.repository

import android.util.Log
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
        Log.e("ddd", ""+result.code()+" :: "+result.body());
        if(result.body() != null){
            Log.e("ddd2", ""+result.code()+" :: "+result.body());
            val response = result.body()
            usersLiveData.postValue(response!!.results)
        }
    }
}