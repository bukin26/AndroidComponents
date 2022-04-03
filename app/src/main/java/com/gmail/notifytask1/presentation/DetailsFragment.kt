package com.gmail.notifytask1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.databinding.FragmentDetailsBinding
import com.gmail.notifytask1.repository.ItemsRepository
import com.gmail.notifytask1.utils.Constants
import com.gmail.notifytask1.viewmodel.DetailsViewModel
import com.gmail.notifytask1.viewmodel.MyViewModelFactory

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var viewModel: DetailsViewModel
    private lateinit var viewModelFactory: MyViewModelFactory
    private lateinit var repository: ItemsRepository


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repository = ItemsRepository(MyPreferences(activity?.applicationContext!!))
        viewModelFactory = MyViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).
        get(DetailsViewModel::class.java)
        val id = savedInstanceState?.getInt(Constants.PREF_KEY) ?: args.id
        viewModel.getItem(id)
        viewModel.item.observe(viewLifecycleOwner) {
            with(binding) {
                itemId.text = it.id.toString()
                itemName.text = it.name
                itemDescription.text = it.description
            }
        }
    }
}