package com.assignement.assignement.ui.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.assignement.assignement.data.repository.HomeScreenRepository;
import com.assignement.assignement.ui.home.viewModel.HomeScreenVM;

public class MainVMFactory implements ViewModelProvider.Factory {

    HomeScreenRepository repository;

    public MainVMFactory(HomeScreenRepository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new HomeScreenVM(repository);
    }
}

