package com.gmail.notifytask1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.databinding.FragmentListBinding
import com.gmail.notifytask1.viewmodel.ListViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val adapter = ItemsAdapter { item -> adapterOnClick(item) }
    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
        adapter.submitList(viewModel.getItemsList())
    }

    private fun adapterOnClick(item: Item) {
        viewModel.setId(item.id)
        val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(item.id)
        findNavController(this@ListFragment).navigate(direction)
    }
}





