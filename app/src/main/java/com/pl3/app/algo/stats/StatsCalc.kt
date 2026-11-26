package com.pl3.app.algo.stats

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

// 保底空壳：移除原统计计算及绘图逻辑
class StatsCalc {
    fun getPlaceholder(): Drawable = ColorDrawable(Color.TRANSPARENT)
    fun calc(): Any = Unit
}
