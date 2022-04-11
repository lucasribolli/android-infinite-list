package com.lucasribolli.infinitelist.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StoredObjectDao {
    @Query("SELECT * FROM StoredObject ORDER BY _id DESC")
    fun getAllPaged(): PagingSource<Int, StoredObject>

    @Insert
    suspend fun insert(item: StoredObject): Long
}