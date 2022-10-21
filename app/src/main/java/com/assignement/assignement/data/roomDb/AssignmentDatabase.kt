package com.assignement.assignement.data.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assignement.assignement.data.roomDb.dao.AssignmentDao
import com.assignement.assignement.data.roomDb.entity.UserDetailsEntity

@Database(entities = [UserDetailsEntity::class], version = 2)
abstract class AssignmentDatabase : RoomDatabase() {
    abstract fun getAssignmentDao(): AssignmentDao
}
