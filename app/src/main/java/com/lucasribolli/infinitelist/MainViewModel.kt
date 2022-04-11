package com.lucasribolli.infinitelist

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import androidx.room.Room
import com.lucasribolli.infinitelist.database.AppDatabase
import com.lucasribolli.infinitelist.database.StoredObject
import com.lucasribolli.infinitelist.database.StoredObjectDao
import kotlinx.coroutines.launch

class MainViewModel constructor(
    context: Application
): AndroidViewModel(context) {
    private val dao: StoredObjectDao = Room
        .databaseBuilder(context, AppDatabase::class.java, "db")
        .build()
        .storedObjectDao()

    fun insertDummyDataInDB() {
        viewModelScope.launch {
            for(i in 0..50) {
                dao.insert(StoredObject(_id = 0, name = "name$i"))
            }
        }
    }

    val items = Pager(
        PagingConfig(
            pageSize = 10,
            enablePlaceholders = true,
            maxSize = 200
        )
    ) {
        dao.getAllPaged()
    }.flow
}