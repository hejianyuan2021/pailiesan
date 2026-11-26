package com.pl3.app.data

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

// 保底编译版：原 entity / Draw / 网络逻辑已清空，仅留空壳确保出包
class DataSource {
    fun getPlaceholder(): Drawable {
        return ColorDrawable(Color.TRANSPARENT)
    }
    fun loadData(): List<Any> {
        return emptyList()
    }
}
