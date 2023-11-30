package com.condex.myamazingplaces.model

import com.condex.myamazingplaces.model.places.FilePlacesDataSource
import com.condex.myamazingplaces.model.places.IPlacesDataSource

object DataSource {
    fun placeDataSource(): IPlacesDataSource {
        return FilePlacesDataSource()
    }
}