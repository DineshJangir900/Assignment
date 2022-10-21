package com.assignement.assignement.data.roomDb.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserDetails")
data class UserDetailsEntity(
    val requestStatus : String,
    val phone : String,
    @PrimaryKey(autoGenerate = true) val id: Int? = null
)
