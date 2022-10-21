package com.assignement.assignement.ui.home.adapter

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.assignement.assignement.data.model.UserDetails
import com.assignement.assignement.databinding.HomeScreenAdapterLayoutBinding
import com.assignement.assignement.ui.base.AssignmentApplication
import com.assignement.assignement.ui.home.view.HomeScreenActivity
import com.bumptech.glide.Glide

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
        val user = mUsersList[position]
        val picture = user.picture
        val location = user.location
        val userLocation = location!!.city!!.plus(", ${location.country}")

        val userRequest = AssignmentApplication.getRoomDb().getAssignmentDao().getUserRequest(user.phone!!)

        if(userRequest != null){
            userRequest.requestStatus.let {
                holder.binding.msgView.visibility = VISIBLE
                holder.binding.requestGroup.visibility = GONE
                if(it == "Y"){
                    holder.binding.msgView.text = "Member Accepted."
                }else{
                    holder.binding.msgView.text = "Member Declined."
                }
            }
        }else{
            holder.binding.msgView.visibility = GONE
            holder.binding.requestGroup.visibility = VISIBLE
        }

        Glide.with(mContext)
            .load(picture!!.large)
            .centerInside()
            .into(holder.binding.userIv)

        val userName  = "${user.name!!.title} ${user.name!!.first} ${user.name!!.last}"
        holder.binding.nameTv.text = userName
        holder.binding.phoneTv.text = user.phone
        holder.binding.locationTv.text = userLocation
        holder.binding.emailTv.text = user.email
        holder.binding.dobTv.text = user.dob!!.date
        holder.binding.ageTv.text = user.dob!!.age.toString()

        holder.binding.acceptTv.setOnClickListener {
            (mContext as HomeScreenActivity).updateRequestStatus(user.phone!!, "Y", position)
            Toast.makeText(mContext,  "Member Accepted.", Toast.LENGTH_SHORT).show()
            holder.binding.msgView.visibility = VISIBLE
            holder.binding.msgView.text = "Member Accepted."
            holder.binding.requestGroup.visibility = GONE
        }

        holder.binding.declineTv.setOnClickListener {
            (mContext as HomeScreenActivity).updateRequestStatus(user.phone!!, "N", position)
            Toast.makeText(mContext,  "Member Declined.", Toast.LENGTH_SHORT).show()
            holder.binding.msgView.visibility = VISIBLE
            holder.binding.msgView.text = "Member Declined."
            holder.binding.requestGroup.visibility = GONE
        }
    }


    override fun getItemCount(): Int {
        return mUsersList.size
    }
}