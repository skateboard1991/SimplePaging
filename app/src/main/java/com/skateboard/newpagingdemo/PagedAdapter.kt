package com.skateboard.newpagingdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class PagedAdapter(retry: (() -> Any?)?) : BasePagedListAdapter<String>(DIFFICULT_CALLBACK,retry) {
    override fun getDateItemViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)
    }

    override fun getErrorItemViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.error_item_layout, parent, false)
        return ErrorItemViewHolder(itemView)
    }

    override fun getLoadingItemViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.loading_item_layout, parent, false)
        return LoadingItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (holder is ItemViewHolder) {
            holder.bindContent(getItem(position) ?: "")
        } else if (holder is ErrorItemViewHolder) {

            holder.retryBtn.setOnClickListener {
                retry?.invoke()?:println("retry method is empty")
            }
        }
    }

    companion object {
        val DIFFICULT_CALLBACK = object : DiffUtil.ItemCallback<String>() {
            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {

                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {

                return oldItem == newItem
            }
        }
    }
}