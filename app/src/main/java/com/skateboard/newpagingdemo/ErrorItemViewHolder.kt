package com.skateboard.newpagingdemo

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class ErrorItemViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {

    val retryBtn=itemView.findViewById<Button>(R.id.retryBtn)

}