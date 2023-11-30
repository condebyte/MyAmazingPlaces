package com.condex.myamazingplaces.ui

import android.content.Context
import android.content.Intent
import com.condex.myamazingplaces.ui.activity.PlacesDetailActvity

object NavigationManager {
    fun openAccidentDetail(ctx: Context, id :Int) {
        val intent = Intent(ctx, PlacesDetailActvity::class.java)
        intent.putExtra(PlacesDetailActvity.EXTRA_ID, id)
        ctx.startActivity(intent)
    }
    fun openAccidentCreate(ctx: Context) {
        val intent = Intent(ctx, PlacesDetailActvity::class.java)
        ctx.startActivity(intent)
    }
}