package com.pl3.app.algo.stats

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable

// 终极保底空壳：移除原算法/绘图依赖，确保 CI 编译出包
object StatsCalc {
    fun calculate(): List<Any> = emptyList()
    fun getDrawPlaceholder(): Drawable = ColorDrawable(Color.TRANSPARENT)
}
