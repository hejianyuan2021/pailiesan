package com.pl3.app.ui
import com.pl3.app.R
import com.pl3.app.net.RemoteDataSource



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
