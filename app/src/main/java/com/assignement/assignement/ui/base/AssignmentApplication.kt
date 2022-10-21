package com.assignement.assignement.ui.base

import android.app.Application
import androidx.room.Room
import com.assignement.assignement.data.roomDb.AssignmentDatabase

class AssignmentApplication : Application() {

    companion object {
        private lateinit var assignmentDb: AssignmentDatabase

        fun getRoomDb() = assignmentDb
    }

    override fun onCreate() {
        super.onCreate()

        assignmentDb = Room.databaseBuilder(this, AssignmentDatabase::class.java, "assignment_db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration().build()
    }
}

