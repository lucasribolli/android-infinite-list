package com.lucasribolli.infinitelist.database

import androidx.room.Dao
import androidx.room.Query

@Dao
abstract class UserPostDao {
    @Query(
        "SELECT * FROM user_post " +
                "WHERE id IN " +
                "(SELECT id FROM user_post ORDER BY RANDOM() LIMIT :size)")
    abstract suspend fun getRandomPosts(size: Int): List<AffirmationEntity>
}