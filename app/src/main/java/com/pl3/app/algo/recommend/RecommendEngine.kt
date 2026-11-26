package com.pl3.app.algo.recommend

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

// 保底空壳：移除原推荐算法及绘图逻辑，确保编译出包
class RecommendEngine {
    fun getPlaceholder(): Drawable = ColorDrawable(Color.TRANSPARENT)
    fun recommend(): List<Any> = emptyList()
}
