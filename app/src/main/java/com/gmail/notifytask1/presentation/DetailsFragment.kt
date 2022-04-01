package com.gmail.notifytask1.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.gmail.notifytask1.data.Item
import com.gmail.notifytask1.databinding.FragmentDetailsBinding
import com.gmail.notifytask1.mvp.contract.DetailsContract
import com.gmail.notifytask1.mvp.presenter.DetailsPresenter
import com.gmail.notifytask1.utils.Constants

class DetailsFragment : Fragment(), DetailsContract.View {

    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()
    private val presenter: DetailsPresenter = DetailsPresenter()

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
        presenter.attachView(this)
        val id = savedInstanceState?.getInt(Constants.PREF_KEY) ?: args.id
        presenter.getItem(id)
    }

    override fun onDestroyView() {
        presenter.detachView()
        super.onDestroyView()
    }

    override fun setItemText(item: Item) {
        with(binding) {
                itemId.text = item.id.toString()
                itemName.text = item.name
                itemDescription.text = item.description
        }
    }
}