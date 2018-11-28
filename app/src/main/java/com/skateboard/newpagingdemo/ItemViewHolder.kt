package com.skateboard.newpagingdemo

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val itemContent = itemView.findViewById<TextView>(R.id.itemTV)

    fun bindContent(item: String) {
        itemContent.text = item
    }
}