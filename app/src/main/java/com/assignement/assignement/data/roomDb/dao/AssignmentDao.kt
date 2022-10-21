package com.assignement.assignement.data.roomDb.dao

import androidx.room.*
import com.assignement.assignement.data.roomDb.entity.UserDetailsEntity

@Dao
interface AssignmentDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUserDetails(userRequest: UserDetailsEntity)


    @Query("Select * from UserDetails where phone == :phone")
    fun getUserRequest(phone : String) : UserDetailsEntity
}