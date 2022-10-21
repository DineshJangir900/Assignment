package com.assignement.assignement.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignement.assignement.data.api.ApiHelper
import com.assignement.assignement.data.api.ApiService
import com.assignement.assignement.data.model.UserDetails
import com.assignement.assignement.data.repository.HomeScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeScreenVM() : ViewModel(){
    private val apiHelpers = ApiHelper.getRetrofitInstance().create(ApiService::class.java)
    private val homeScreenRepository = HomeScreenRepository(apiHelpers)


    init {
        viewModelScope.launch(Dispatchers.IO){
            homeScreenRepository.getUsers(3)
        }
    }

    val users : LiveData<MutableList<UserDetails>>
    get() = homeScreenRepository.users

}