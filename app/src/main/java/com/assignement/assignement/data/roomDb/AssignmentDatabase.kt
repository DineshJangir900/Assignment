package com.assignement.assignement.data.roomDb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.assignement.assignement.data.roomDb.dao.AssignmentDao

//@Database(entities = [AssignmentDatabase::class], version = 1)
abstract class AssignmentDatabase : RoomDatabase() {
  //  abstract fun getAssignmentDao(): AssignmentDao
}
