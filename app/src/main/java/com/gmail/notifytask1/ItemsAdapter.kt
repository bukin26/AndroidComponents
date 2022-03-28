package com.gmail.notifytask1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gmail.notifytask1.databinding.ItemListBinding


class ItemsAdapter(private val onClick: (View, Int) -> Unit) :
    ListAdapter<Item, ItemsAdapter.ItemsViewHolder>(ItemDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemsViewHolder(ItemListBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, onClick)
    }

    class ItemsViewHolder(
        private val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, onClick: (View, Int) -> Unit) {
            with(binding) {
                itemName.text = item.name
                root.setOnClickListener { onClick(root, item.id) }
            }
        }

    }
}

object ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }
}