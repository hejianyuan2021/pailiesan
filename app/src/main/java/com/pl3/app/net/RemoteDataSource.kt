package com.pl3.app.net

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

// 保底空壳：仅占位
class RemoteDataSource {
    fun getPlaceholder(): Drawable {
        return ColorDrawable(Color.TRANSPARENT)
    }
    fun fetchData() {
        // TODO: 后续补回
    }
}
