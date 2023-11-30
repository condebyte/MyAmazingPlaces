package com.condex.myamazingplaces.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.condex.myamazingplaces.R

class PlacesDetailActvity: AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_places_detail)
    }
    companion object {
        val EXTRA_ID: String="ID"
    }
}