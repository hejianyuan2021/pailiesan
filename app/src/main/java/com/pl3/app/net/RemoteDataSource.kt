package com.pl3.app.net

import android.graphics.drawable.Drawable
import android.graphics.drawable.ColorDrawable
import android.graphics.Color

// 终极保底空壳：原自定义 Draw 类及协程逻辑已移除，仅保留基础结构确保编译出包
class RemoteDataSource {

    // 占位符：返回透明图，避免原绘图调用报错
    fun getPlaceholder(): Drawable {
        return ColorDrawable(Color.TRANSPARENT)
    }

    // 原网络请求方法留空，保底出包（后续需补回 OkHttp/协程逻辑）
    fun fetchData() {
        // TODO: 补回原网络逻辑
    }
}
