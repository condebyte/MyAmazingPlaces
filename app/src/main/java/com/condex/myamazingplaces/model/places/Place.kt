package com.condex.myamazingplaces.model.places

data class Place (

    var id: Int,
    var tlf: Int,
    var lugar: String,
    var foto: String,
    var valoracion: String,
    var web: String,
    var tipoSitio: TipoSitio
)