package com.gmail.notifytask1.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.databinding.FragmentListBinding
import com.gmail.notifytask1.presentation.ItemsAdapter

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val adapter = ItemsAdapter { item -> adapterOnClick(item) }
    private val viewModel: ListViewModel by lazy {
        val viewModelFactory =
            ListViewModelFactory(MyPreferences(requireActivity().applicationContext))
        ViewModelProvider(viewModelStore, viewModelFactory)
            .get(ListViewModel::class.java)
    }

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
        viewModel.state.observe(viewLifecycleOwner, ::renderState)
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
    }

    private fun renderState(newState: ListState) {
        adapter.submitList(newState.items)
    }

    private fun adapterOnClick(item: Item) {
        viewModel.sendSetIdIntent(item.id)
        val direction =
            ListFragmentDirections.actionListFragmentToDetailsFragment(
                item.id
            )
        findNavController(this@ListFragment).navigate(direction)
    }
}





