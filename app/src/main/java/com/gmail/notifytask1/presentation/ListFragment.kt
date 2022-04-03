package com.gmail.notifytask1.presentation

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
import com.gmail.notifytask1.repository.ItemsRepository
import com.gmail.notifytask1.viewmodel.ListViewModel
import com.gmail.notifytask1.viewmodel.MyViewModelFactory

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding
    private val adapter = ItemsAdapter { item -> adapterOnClick(item) }
    private lateinit var viewModel: ListViewModel
    private lateinit var viewModelFactory: MyViewModelFactory
    private lateinit var repository: ItemsRepository


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
        repository = ItemsRepository(MyPreferences(activity?.applicationContext!!))
        viewModelFactory = MyViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ListViewModel::class.java)
        with(binding) {
            recyclerView.layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = adapter
        }
        viewModel.getItemsList()
        viewModel.items.observe(viewLifecycleOwner) { newItems ->
            adapter.submitList(newItems)
        }
    }

    private fun adapterOnClick(item: Item) {
        viewModel.setId(item.id)
        val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(item.id)
        findNavController(this@ListFragment).navigate(direction)
    }
}





