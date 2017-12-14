package com.tolodev.buildandy.ui.fragments

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.ClipData
import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.tolodev.buildandy.R
import com.tolodev.buildandy.data.AndyImageAssets
import com.tolodev.buildandy.databinding.FragmentHomeBinding
import com.tolodev.buildandy.ui.activities.MainActivity
import com.tolodev.buildandy.ui.adapter.AndyAdapter
import com.tolodev.buildandy.util.DeviceUtil
import com.tolodev.buildandy.viewmodel.SharedViewModel

class HomeFragment : Fragment(), AdapterView.OnItemClickListener {

    private lateinit var homeBinding: FragmentHomeBinding
    private lateinit var adapter: AndyAdapter
    private lateinit var homeFragmentListener: HomeFragmentListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        homeBinding.fragment = this
        setupView()
        return homeBinding.root
    }

    private fun setupView() {
        adapter = AndyAdapter(context, AndyImageAssets.getAll())
        if (isTablet()) {
            homeBinding.imagesGridView.numColumns = 2
        }
        homeBinding.imagesGridView.adapter = adapter
        homeBinding.imagesGridView.onItemClickListener = this
    }

    fun isTablet() = DeviceUtil.isTablet()

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val itemSelected = adapter.getItem(position)

        if (DeviceUtil.isTablet()) {
            val sharedViewModel: SharedViewModel = ViewModelProviders.of(activity as MainActivity).get(SharedViewModel::class.java)
            val item: ClipData.Item = ClipData.Item(position.toString())
            sharedViewModel.select(item)
        } else {
            homeFragmentListener.imageSelected(itemSelected as Int, position)
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            homeFragmentListener = context as HomeFragmentListener
        }
    }

    fun continueClick() {
        homeFragmentListener.showAndy()
    }

    interface HomeFragmentListener {
        fun imageSelected(imageSelected: Int, index: Int)

        fun showAndy()
    }
}