package com.gmail.notifytask1.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.databinding.ItemListBinding


class ItemsAdapter(
    private val onClick: (Item) -> Unit
) : ListAdapter<Item, ItemsAdapter.ItemsViewHolder>(ItemDiffCallback) {

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

        fun bind(item: Item, onClick: (Item) -> Unit) {
            with(binding) {
                itemName.text = item.name
                root.setOnClickListener { onClick(item) }
            }
        }
    }
}

object ItemDiffCallback : DiffUtil.ItemCallback<Item>() {
    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
        return oldItem == newItem
    }
}