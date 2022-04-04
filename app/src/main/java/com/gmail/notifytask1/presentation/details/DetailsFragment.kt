package com.gmail.notifytask1.presentation.details

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

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var viewModel: DetailsViewModel

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
        val id = savedInstanceState?.getInt(Constants.PREF_KEY) ?: args.id
        val repository = ItemsRepository(MyPreferences(requireActivity().applicationContext))
        val viewModelFactory = DetailsViewModelFactory(repository, id)
        viewModel = ViewModelProvider(viewModelStore, viewModelFactory)
            .get(DetailsViewModel::class.java)
        viewModel.item.observe(viewLifecycleOwner) {
            with(binding) {
                itemId.text = it.id.toString()
                itemName.text = it.name
                itemDescription.text = it.description
            }
        }
    }
}