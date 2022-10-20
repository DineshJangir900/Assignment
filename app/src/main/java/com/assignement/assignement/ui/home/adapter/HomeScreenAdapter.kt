package com.assignement.assignement.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assignement.assignement.data.model.UserDetails
import com.assignement.assignement.databinding.HomeScreenAdapterLayoutBinding

class HomeScreenAdapter(
    private val mContext: Context,
    private val mUsersList: MutableList<UserDetails>
) : RecyclerView.Adapter<HomeScreenAdapter.HomeScreenAdapterViewHolder>() {

    class HomeScreenAdapterViewHolder(val binding: HomeScreenAdapterLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeScreenAdapterViewHolder {
        val binding =
            HomeScreenAdapterLayoutBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return HomeScreenAdapterViewHolder(binding)
    }


    override fun onBindViewHolder(holder: HomeScreenAdapterViewHolder, position: Int) {

    }


    override fun getItemCount(): Int {
        return mUsersList.size
    }
}