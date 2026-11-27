package com.pl3.app.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.pl3.app.algo.entity.Draw
import com.pl3.app.algo.recommend.RecommendEngine
import com.pl3.app.algo.stats.StatsCalc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val tv = findViewById<TextView>(R.id.tvResult)
        Thread {
            try {
                val history: List<Draw> = emptyList()
                val stats = StatsCalc.calc(history)
                val recs = RecommendEngine.recommend(history, stats, 10)
                val sb = StringBuilder()
                recs.forEach { item ->
                    val numStr = item.num.joinToString("")
                    val reasonStr = item.reason
                    sb.append(numStr).append("\n").append(reasonStr).append("\n\n")
                }
                runOnUiThread { tv.text = sb.toString().trim() }
            } catch (e: Exception) {
                runOnUiThread { tv.text = "失败：${e.message}" }
            }
        }.start()
    }
}
