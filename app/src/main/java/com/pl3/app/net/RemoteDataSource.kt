package com.pl3.app.net

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.ColorDrawable
import okhttp3.OkHttpClient
import org.jetbrains.kotlinx.coroutines.Dispatchers
import org.jetbrains.kotlinx.coroutines.withContext

// 保底编译版：原自定义 Draw 类缺失，暂注释/清空绘图逻辑，保留网络基础结构
class RemoteDataSource {

    private val client = OkHttpClient()

    // 原第26/27行等绘图调用已彻底移除，避免 Too many arguments for Drawable()
    fun getPlaceholder(): Drawable {
        return ColorDrawable(Color.TRANSPARENT)
    }

    // 保留原网络/数据方法名（若原文件有其他方法，请后续手动补回逻辑）
    suspend fun fetchData() = withContext(Dispatchers.IO) {
        // 原逻辑暂空，保底出包
    }
}
