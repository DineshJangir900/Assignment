package com.assignement.assignement.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import com.assignement.assignement.R
import com.assignement.assignement.data.api.ApiHelper
import com.assignement.assignement.data.api.ApiService
import com.assignement.assignement.data.repository.HomeScreenRepository
import com.assignement.assignement.databinding.ActivityHomeScreenBinding
import com.assignement.assignement.databinding.HomeScreenAdapterLayoutBinding
import com.assignement.assignement.ui.base.MainViewModelFactory
import com.assignement.assignement.ui.home.viewModel.HomeScreenVM

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityHomeScreenBinding
    private lateinit var mHomeScreenVM: HomeScreenVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
        mBinding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()
        getUsers()
    }


    private fun init() {
        val apiHelpers = ApiHelper.getRetrofitInstance().create(ApiService::class.java)
        val homeScreenRepository = HomeScreenRepository(apiHelpers)
        mHomeScreenVM = ViewModelProvider(this, MainViewModelFactory(homeScreenRepository)).get(HomeScreenVM::class.java)
    }


    private fun getUsers() {
        mHomeScreenVM.users.observe(this, {
            Log.e("dddd", ""+it.size)
            Log.e("ddddf", ""+it.toString())
        })
    }


    //Function to show progress ui
    private fun showProgressView(){
        mBinding.progressCircular.visibility = VISIBLE
    }

    //Function to hide progress ui
    private fun hideProgressView(){
        mBinding.progressCircular.visibility = GONE
    }
}