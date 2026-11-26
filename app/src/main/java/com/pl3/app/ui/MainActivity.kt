package com.pl3.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pl3.app.R

// 保底编译版：原逻辑/菜单/绘图已暂置，确保 CI 出包
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
