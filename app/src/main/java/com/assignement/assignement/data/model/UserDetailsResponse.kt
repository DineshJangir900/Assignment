package com.assignement.assignement.data.model

import com.google.gson.annotations.SerializedName

data class UserDetailsResponse(
    @SerializedName("results" ) var results : ArrayList<UserDetails> = arrayListOf(),
    @SerializedName("info"    ) var info    : Info?              = Info()
)
