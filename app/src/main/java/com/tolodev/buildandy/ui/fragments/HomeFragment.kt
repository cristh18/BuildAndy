package com.tolodev.buildandy.ui.fragments

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tolodev.buildandy.R
import com.tolodev.buildandy.data.AndyImageAssets
import com.tolodev.buildandy.databinding.FragmentHomeBinding
import com.tolodev.buildandy.ui.adapter.AndyAdapter

class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mParam1 = it.getString(ARG_PARAM1)
            mParam2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        // Get a reference to the GridView in the fragment_master_list xml layout file


        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        val mAdapter = AndyAdapter(context, AndyImageAssets.getAll())

        // Set the adapter on the GridView
        homeBinding.imagesGridView.adapter = mAdapter

        return homeBinding.root
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        fun newInstance(param1: String, param2: String): HomeFragment {
            val fragment = HomeFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }
}