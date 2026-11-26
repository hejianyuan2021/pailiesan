package com.pl3.app.net

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.ColorDrawable

// 终极保底空壳：仅占位，确保编译出包
class RemoteDataSource {
    fun getPlaceholder(): Drawable {
        return ColorDrawable(Color.TRANSPARENT)
    }
    fun fetchData() {
        // TODO: 后续补回网络逻辑
    }
}
