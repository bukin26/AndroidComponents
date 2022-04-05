package com.gmail.notifytask1.presentation.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.gmail.notifytask1.databinding.FragmentDetailsBinding
import com.gmail.notifytask1.utils.Constants

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: DetailsViewModel by lazy {
        val itemId = arguments?.getInt(Constants.PREF_KEY) ?: args.id
        val viewModelFactory = DetailsViewModelFactory(itemId)
        ViewModelProvider(viewModelStore, viewModelFactory)
            .get(DetailsViewModel::class.java)
    }

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
        viewModel.state.observe(viewLifecycleOwner, ::renderState)
    }

    private fun renderState(newState: DetailsState) {
        with(binding) {
            itemId.text = newState.item.id.toString()
            itemName.text = newState.item.name
            itemDescription.text = newState.item.description
        }
    }
}