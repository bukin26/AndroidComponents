package com.gmail.notifytask1


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.notifytask1.databinding.FragmentListBinding

const val PREF_KEY = "ID"

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
        val preferences =
            requireContext().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        with(preferences.edit()) {
            putInt(PREF_KEY, item.id)
            apply()
            val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(item.id)
            findNavController(this@ListFragment).navigate(direction)
        }
    }
}




