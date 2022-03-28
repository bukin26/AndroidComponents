package com.gmail.notifytask1

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.gmail.notifytask1.databinding.ItemListBinding


class ItemsAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<ItemsAdapter.ItemsViewHolder>() {

    companion object {
        const val PREF_KEY = "ID"
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ItemsViewHolder(ItemListBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = items[position]

        with(holder.binding) {
            itemName.text = item.name
            root.setOnClickListener {
                val preferences =
                    it.context.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
                with(preferences.edit()) {
                    putInt(PREF_KEY, item.id)
                    apply()
                }

                it.findNavController().navigate(R.id.action_listFragment_to_detailsFragment)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class ItemsViewHolder(
        val binding: ItemListBinding
    ) : RecyclerView.ViewHolder(binding.root)
}