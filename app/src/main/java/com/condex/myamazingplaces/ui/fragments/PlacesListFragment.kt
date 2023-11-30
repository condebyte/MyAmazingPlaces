package com.condex.myamazingplaces.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.condex.myamazingplaces.databinding.FragmentPlaceListBinding
import com.condex.myamazingplaces.model.DataSource
import com.condex.myamazingplaces.ui.adapters.PlacesListAdapter

class PlacesListFragment : Fragment() {
    private lateinit var binding: FragmentPlaceListBinding
    private lateinit var ctx: Context
    private lateinit var adapter: PlacesListAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaceListBinding.inflate(inflater)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListener()
        configView()
    }

    private fun configView() {
        adapter = PlacesListAdapter()
        val places = DataSource.placeDataSource().listPlaces(ctx)
        adapter.setData(places)
        binding.listview.adapter = adapter
    }

    private fun setListener() {

    }
}