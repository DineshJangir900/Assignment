package com.assignement.assignement.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import com.assignement.assignement.R
import com.assignement.assignement.databinding.ActivityHomeScreenBinding
import com.assignement.assignement.databinding.HomeScreenAdapterLayoutBinding

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityHomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
        mBinding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)
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