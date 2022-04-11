package com.lucasribolli.infinitelist.database

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_post")
data class UserPostEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    @NonNull
    val id: Long = 0L,

    @ColumnInfo(name = "text")
    @NonNull
    var text: String
)