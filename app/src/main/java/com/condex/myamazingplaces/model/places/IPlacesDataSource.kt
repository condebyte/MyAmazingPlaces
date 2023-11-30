package com.condex.myamazingplaces.model.places

import android.content.Context

interface IPlacesDataSource {

    fun addPlaces(context: Context, place: Place)

    fun updatePlaces(context: Context, id: Int, place: Place )

    fun borrarPlaces(context: Context, id: Int)

    fun get(context: Context, id:Int):Place

    fun listPlaces(context:Context):List<Place>
}