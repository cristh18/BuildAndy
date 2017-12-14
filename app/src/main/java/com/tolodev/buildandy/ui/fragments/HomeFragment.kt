package com.tolodev.buildandy.ui.fragments

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.tolodev.buildandy.R
import com.tolodev.buildandy.data.AndyImageAssets
import com.tolodev.buildandy.databinding.FragmentHomeBinding
import com.tolodev.buildandy.ui.adapter.AndyAdapter

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
        homeBinding.imagesGridView.adapter = adapter
        homeBinding.imagesGridView.onItemClickListener = this
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val itemSelected = adapter.getItem(position)
        homeFragmentListener.imageSelected(itemSelected as Int, position)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        context?.let {
            homeFragmentListener = context as HomeFragmentListener
        }
    }

    fun continueClick(){
        homeFragmentListener.showAndy()
    }

    interface HomeFragmentListener {
        fun imageSelected(imageSelected: Int, index : Int)

        fun showAndy()
    }
}