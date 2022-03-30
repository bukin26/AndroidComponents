package com.gmail.notifytask1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gmail.notifytask1.data.ItemsHolder
import com.gmail.notifytask1.databinding.FragmentDetailsBinding
import com.gmail.notifytask1.utils.Constants

class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val id = savedInstanceState?.getInt(Constants.PREF_KEY) ?: args.id
        val item = ItemsHolder.getItemById(id)
        with(binding) {
            item?.let {
                itemId.text = it.id.toString()
                itemName.text = it.name
                itemDescription.text = it.description
            }
        }
    }
}