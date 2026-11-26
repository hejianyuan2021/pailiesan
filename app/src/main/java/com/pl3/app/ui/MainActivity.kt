package com.pl3.app.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pl3.app.R
import com.pl3.app.algo.recommend.RecommendEngine
import com.pl3.app.data.RemoteDataSource
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        supportActionBar?.title = "排列三 · 推荐"

        thread {
            try {
                val data = RemoteDataSource().fetchHistory()
                val recs = RecommendEngine.recommend(data, 10)
                runOnUiThread {
                    if (recs.isEmpty()) {
                        tvResult.text = "数据不足，无法生成推荐"
                    } else {
                        supportActionBar?.title = "排列三 · 推荐 ${recs.size}组"
                        tvResult.text = recs.joinToString("\n\n") { 
                            "${it.num}\n${it.reason}" 
                        }
                    }
                }
            } catch (e: Exception) {
                runOnUiThread {
                    tvResult.text = "计算失败: ${e.message}"
                }
            }
        }
    }
}
