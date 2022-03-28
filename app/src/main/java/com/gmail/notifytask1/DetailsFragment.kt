package com.gmail.notifytask1

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gmail.notifytask1.ItemsAdapter.Companion.PREF_KEY
import com.gmail.notifytask1.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        val preferences = context?.getSharedPreferences("MyPreferences", Context.MODE_PRIVATE)
        val id = preferences?.getInt(PREF_KEY, -1)

        binding.itemId.text = "ID $id"
        binding.itemName.text = "Name $id"
        binding.itemDescription.text = "Description $id"

        return binding.root
    }
}