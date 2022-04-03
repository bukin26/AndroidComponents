package com.gmail.notifytask1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.gmail.notifytask1.data.MyPreferences
import com.gmail.notifytask1.databinding.FragmentDetailsBinding
import com.gmail.notifytask1.mvi.MainIntent
import com.gmail.notifytask1.mvi.MainState
import com.gmail.notifytask1.utils.Constants
import com.gmail.notifytask1.viewmodel.DetailsViewModel
import com.gmail.notifytask1.viewmodel.MyViewModelFactory
import kotlinx.coroutines.launch

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private lateinit var viewModel: DetailsViewModel
    private lateinit var viewModelFactory: MyViewModelFactory

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
        viewModelFactory = MyViewModelFactory(MyPreferences(activity?.applicationContext!!))
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(DetailsViewModel::class.java)
        val id = savedInstanceState?.getInt(Constants.PREF_KEY) ?: args.id

        lifecycleScope.launch {
            viewModel.intents.send(MainIntent.GetItem(id = id))
        }
        viewModel.state.observe(viewLifecycleOwner) { state ->
            if (state is MainState.DetailedItem) {
                with(binding) {
                    itemId.text = state.item.id.toString()
                    itemName.text = state.item.name
                    itemDescription.text = state.item.description
                }
            }
        }
    }
}