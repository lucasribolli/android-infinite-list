package com.lucasribolli.infinitelist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucasribolli.infinitelist.R
import com.lucasribolli.infinitelist.database.StoredObject

class ListViewHolder(
    parent: ViewGroup
): RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(R.layout.list_item, parent, false)
) {
    private val nameView = itemView.findViewById<TextView>(R.id.name)
    private var _storedObject: StoredObject? = null

    fun bindTo(storedObject: StoredObject?) {
        _storedObject = storedObject
        nameView.text = "${storedObject?._id} - ${storedObject?.name}"
    }
}