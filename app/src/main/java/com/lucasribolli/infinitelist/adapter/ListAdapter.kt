package com.lucasribolli.infinitelist.adapter

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.lucasribolli.infinitelist.database.StoredObject

class ListAdapter(): PagingDataAdapter<StoredObject, ListViewHolder>(DIFF_CALLBACK) {
    companion object {
        private val DIFF_CALLBACK = object :
            DiffUtil.ItemCallback<StoredObject>() {
            override fun areItemsTheSame(
                oldItem: StoredObject,
                newItem: StoredObject
            ) = oldItem._id == newItem._id

            override fun areContentsTheSame(
                oldItem: StoredObject,
                newItem: StoredObject
            ) = oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val storedObject: StoredObject? = getItem(position)
        holder.bindTo(storedObject)
    }
}