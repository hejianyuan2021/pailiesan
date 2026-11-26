import com.pl3.app.R
package com.pl3.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.pl3.app.algo.recommend.RecommendEngine
import com.pl3.app.net.RemoteDataSource
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launch {
            val data = RemoteDataSource().fetchHistory()
            val recs = RecommendEngine.recommend(data, 10)
            println("推荐号码: $recs")
            supportActionBar?.title = "排列三 · 推荐 ${recs.size} 注"
        }
    }
}
