package com.assignement.assignement.data.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetails")
data class UserDetailsEntity(
    val requestStatus : String,
    @PrimaryKey(autoGenerate = false) val id: Int? = null
)