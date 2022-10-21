package com.assignement.assignement.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignement.assignement.data.model.UserDetails
import com.assignement.assignement.data.repository.HomeScreenRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HomeScreenVM(private val homeScreenRepository: HomeScreenRepository) : ViewModel(){

    init {
        viewModelScope.launch(Dispatchers.IO){
            homeScreenRepository.getUsers(10)
        }
    }

    val users : LiveData<MutableList<UserDetails>>
    get() = homeScreenRepository.users

}