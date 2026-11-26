package com.pl3.app.net

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

class RemoteDataSource {
    fun getPlaceholder(): Drawable = ColorDrawable(Color.TRANSPARENT)
    fun fetchData() {}
}
