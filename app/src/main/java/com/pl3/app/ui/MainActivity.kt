package com.pl3.app.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pl3.app.R
import com.pl3.app.algo.recommend.RecommendEngine
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tvResult)
        supportActionBar?.title = "排列三"
        thread {
            try {
                val recs = RecommendEngine.recommend(emptyList(), 10)
                runOnUiThread {
                    if (recs.isEmpty()) { tv.text = "数据不足" } else {
                        tv.text = recs.joinToString("\n\n") { item ->
                            val n = item.num
                            val numStr = if (n is List<*>) n.joinToString("") { it.toString() } else n.toString()
                            val r = item.reason?.toString() ?: ""
                            "$numStr\n$r"
                        }
                    }
                }
            } catch (e: Exception) { runOnUiThread { tv.text = "失败: ${e.message}" } }
        }
    }
}
