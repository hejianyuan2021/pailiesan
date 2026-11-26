package com.pl3.app.data

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

class DataSource {
    fun getPlaceholder(): Drawable = ColorDrawable(Color.TRANSPARENT)
    fun loadData(): List<Any> = emptyList()
}
