package com.gmail.notifytask1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.databinding.FragmentListBinding
import com.gmail.notifytask1.mvp.contract.ListContract
import com.gmail.notifytask1.mvp.presenter.ListPresenter

class ListFragment : Fragment(), ListContract.View {

    private lateinit var binding: FragmentListBinding
    private val adapter = ItemsAdapter { item -> adapterOnClick(item) }
    private lateinit var pref: MyPreferences
    private lateinit var presenter: ListPresenter

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
        pref = MyPreferences(requireContext())
        presenter = ListPresenter(pref)
        presenter.attachView(this)
        presenter.getItemsList()
    }

    private fun adapterOnClick(item: Item) {
        presenter.setId(item.id)
        val direction = ListFragmentDirections.actionListFragmentToDetailsFragment(item.id)
        findNavController(this@ListFragment).navigate(direction)
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun submitItems(items: List<Item>) {
        adapter.submitList(items)
    }
}





