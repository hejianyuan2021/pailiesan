package com.pl3.app.algo.recommend

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

class RecommendEngine {
    fun getPlaceholder(): Drawable = ColorDrawable(Color.TRANSPARENT)
    fun recommend(): List<Any> = emptyList()
}
