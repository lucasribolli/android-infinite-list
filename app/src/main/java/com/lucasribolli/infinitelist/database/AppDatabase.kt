package com.lucasribolli.infinitelist.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [StoredObject::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun storedObjectDao(): StoredObjectDao
}