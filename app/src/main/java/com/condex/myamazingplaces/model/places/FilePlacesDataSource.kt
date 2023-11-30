package com.condex.myamazingplaces.model.places

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException


class FilePlacesDataSource:IPlacesDataSource {
    private val fileName = "accidents.json"

    private fun savePLaces(context: Context, accidents: List<Place>) {
        val file = File(context.getExternalFilesDir(null), fileName)
        try {
            file.writeText(Gson().toJson(accidents))
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    private fun loadPlaces(context: Context): List<Place> {
        val file = File(context.getExternalFilesDir(null), fileName)
        return try {
            val json = file.readText()
            val typeToken = object : TypeToken<List<Place>>() {}.type
            Gson().fromJson(json, typeToken)
        } catch (e: IOException) {
            mutableListOf()
        }
    }

    override fun addPlaces(context: Context, place: Place) {
        val places = loadPlaces(context).toMutableList()
        places.add(place)
        savePLaces(context,places)
    }

    override fun updatePlaces(context: Context, id: Int, place: Place) {
        val places = loadPlaces(context).toMutableList()
        val index = places.indexOfFirst { it.id == id }
        if (index != -1) {
            places[index] = place
            savePLaces(context, places)
        }
    }

    override fun borrarPlaces(context: Context, id: Int) {
        val places = loadPlaces(context).toMutableList()
        val index = places.indexOfFirst { it.id == id }
        if (index != -1) {
            places.removeAt(index)
            savePLaces(context,places)
        }
    }

    override fun get(context: Context, id: Int): Place {
        val places = loadPlaces(context)
        return places.firstOrNull { it.id == id } ?: throw NoSuchElementException("Places not found")
    }

    override fun listPlaces(context: Context): List<Place> {
        return loadPlaces(context)
    }
}