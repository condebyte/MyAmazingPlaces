package com.condex.myamazingplaces.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.condex.myamazingplaces.databinding.PlacesAdapterItemBinding
import com.condex.myamazingplaces.model.DataSource
import com.condex.myamazingplaces.ui.adapters.PlacesListAdapter

import com.condex.myamazingplaces.model.places.Place


class PlacesListAdapter() : BaseAdapter()  {
    private lateinit var context: Context
    private lateinit var list:  List<Place>

    constructor(context: Context, list:  List<Place>) : this() {
        this.context = context
        this.list = list
    }

    override fun getCount(): Int {
        return this.list.size
    }

    override fun getItem(position: Int): Any {
        return this.list[position]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, p1: View?, p2: ViewGroup?): View {
        val item = this.list[position]
        val inflator = context!!.getSystemService(
            Context.LAYOUT_INFLATER_SERVICE
        ) as LayoutInflater
        val binding = PlacesAdapterItemBinding.inflate(inflator)

        binding.txtLugar.text = item.lugar
        binding.txtWeb.text = item.web
        return binding.root
        
    }

    fun setData(place: List<Place>) {
        this.list = place
    }
}