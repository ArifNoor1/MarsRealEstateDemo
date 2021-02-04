package com.example.marsrealestatedemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.marsrealestatedemo.databinding.GridViewItemBinding
import com.example.marsrealestatedemo.local.Mars

class PhotoGridAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Mars, PhotoGridAdapter.MarsViewHolder>(DiffCallback) {

    class MarsViewHolder(private var binding: GridViewItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mars: Mars) {
            binding.propertyVM = mars
            binding.executePendingBindings()

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<Mars>() {
        override fun areItemsTheSame(oldItem: Mars, newItem: Mars): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Mars, newItem: Mars): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MarsViewHolder {
        return MarsViewHolder(GridViewItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MarsViewHolder, position: Int) {
        val marsProperty = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(marsProperty)
        }
        holder.bind(marsProperty)
    }

    class OnClickListener(val clickListener: (mars: Mars) -> Unit) {
        fun onClick(mars: Mars) = clickListener(mars)
    }

}



