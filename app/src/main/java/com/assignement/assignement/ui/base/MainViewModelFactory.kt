package com.assignement.assignement.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.assignement.assignement.data.repository.HomeScreenRepository
import com.assignement.assignement.ui.home.viewModel.HomeScreenVM


class MainViewModelFactory(private val repository : HomeScreenRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeScreenVM::class.java)) {
            return HomeScreenVM(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

