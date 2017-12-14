package com.tolodev.buildandy.ui.fragments

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tolodev.buildandy.R
import com.tolodev.buildandy.databinding.FragmentBodyPartBinding
import com.tolodev.buildandy.ui.activities.MainActivity
import com.tolodev.buildandy.util.DeviceUtil
import com.tolodev.buildandy.viewmodel.BodyPartViewModel
import com.tolodev.buildandy.viewmodel.SharedViewModel

class BodyPartFragment : Fragment() {

    private var imageIndex: Int = 0
    private var bodySection: Int = 0
    private lateinit var bodyPartBinding: FragmentBodyPartBinding
    private lateinit var bodyPartViewModel: BodyPartViewModel

    companion object {

        val ARG_IMAGE_INDEX = "ARG_IMAGE_INDEX"
        val ARG_BODY_PART_TYPE = "ARG_BODY_PART_TYPE"

        fun newInstance(imageIndex: Int, bodySection: Int): BodyPartFragment {
            val fragment = BodyPartFragment()
            val args = Bundle()
            args.putInt(ARG_IMAGE_INDEX, imageIndex)
            args.putInt(ARG_BODY_PART_TYPE, bodySection)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            imageIndex = it.getInt(ARG_IMAGE_INDEX)
            bodySection = it.getInt(ARG_BODY_PART_TYPE)
        }
        handleBodyPartNotifications()
    }

    private fun handleBodyPartNotifications() {
        if (DeviceUtil.isTablet()) {
            val sharedViewModel: SharedViewModel = ViewModelProviders.of(activity as MainActivity).get(SharedViewModel::class.java)
            sharedViewModel.getSelected().observe(this, Observer { t ->
                val indexSelected = t?.text.toString().toInt()
                updateUI(indexSelected, bodySection)
            })
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bodyPartBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_body_part, container, false)
        bodyPartViewModel = ViewModelProviders.of(this).get(BodyPartViewModel::class.java)
        if (savedInstanceState != null) {
            imageIndex = savedInstanceState.getInt(ARG_IMAGE_INDEX)
            bodySection = savedInstanceState.getInt(ARG_BODY_PART_TYPE)
        }
        init()
        return bodyPartBinding.root
    }

    private fun init() {
        bodyPartViewModel.init(imageIndex, bodySection)
        bodyPartBinding.bodyPartViewModel = bodyPartViewModel
    }

    private fun updateUI(imageIndex: Int, bodySection: Int) {
        bodyPartViewModel.init(imageIndex, bodySection)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
        bodyPartViewModel.unsubscribe()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_IMAGE_INDEX, bodyPartViewModel.imageIndex)
        outState.putInt(ARG_BODY_PART_TYPE, bodyPartViewModel.bodySection)
    }
}
