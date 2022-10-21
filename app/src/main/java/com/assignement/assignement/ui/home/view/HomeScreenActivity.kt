package com.assignement.assignement.ui.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import com.assignement.assignement.R
import com.assignement.assignement.data.model.UserDetails
import com.assignement.assignement.data.roomDb.entity.UserDetailsEntity
import com.assignement.assignement.databinding.ActivityHomeScreenBinding
import com.assignement.assignement.ui.base.AssignmentApplication
import com.assignement.assignement.ui.home.adapter.HomeScreenAdapter
import com.assignement.assignement.ui.home.viewModel.HomeScreenVM

class HomeScreenActivity : AppCompatActivity() {

    private lateinit var mBinding : ActivityHomeScreenBinding
    private lateinit var mHomeScreenVM: HomeScreenVM
    private lateinit var mUsersList : MutableList<UserDetails>

    private lateinit var mHomeScreenAdapter: HomeScreenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_AppCompat_Light_NoActionBar)
        mBinding = ActivityHomeScreenBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()

        getUsers()
    }


    private fun init() {
        mUsersList = mutableListOf()
        mHomeScreenVM = ViewModelProvider(this)[HomeScreenVM::class.java]
    }


    private fun getUsers() {
        showProgressView()

        mHomeScreenVM.users.observe(this, {
            Log.e("dddd", ""+it.size)
            mUsersList = it
            hideProgressView()
            setUsersRv()
        })
    }


    private fun setUsersRv() {
        mHomeScreenAdapter = HomeScreenAdapter(this, mUsersList)
        mBinding.usersListRv.adapter = mHomeScreenAdapter
    }


    //Function to show progress ui
    private fun showProgressView(){
        mBinding.progressCircular.visibility = VISIBLE
    }

    //Function to hide progress ui
    private fun hideProgressView(){
        mBinding.progressCircular.visibility = GONE
    }


    override fun onDestroy() {
        super.onDestroy()
        mUsersList.clear()
    }

    fun updateRequestStatus(phone: String, status: String, position: Int) {
        val userRequestStatus = UserDetailsEntity(phone, status)
        AssignmentApplication.getRoomDb().getAssignmentDao().insertUserDetails(userRequestStatus)
        mHomeScreenAdapter.notifyItemChanged(position)
    }
}