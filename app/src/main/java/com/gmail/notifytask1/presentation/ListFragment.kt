package com.gmail.notifytask1.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.databinding.FragmentListBinding
import com.gmail.notifytask1.utils.Constants
import com.gmail.notifytask1.data.ItemsHolder

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val adapter = ItemsAdapter { item -> adapterOnClick(item) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
        adapter.submitList(ItemsHolder.items)
    }

    private fun adapterOnClick(item: Item) {
        requireContext().getSharedPreferences(Constants.MY_PREFERENCES, Context.MODE_PRIVATE).edit {
                putInt(Constants.PREF_KEY, item.id)
            }
        val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(item.id)
        findNavController(this@ListFragment).navigate(direction)
    }
}





