package com.pl3.app.ui
import com.pl3.app.R
import com.pl3.app.net.RemoteDataSource
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    // 若原代码有 RemoteDataSource 调用，保留；此处兜底声明避免 net 报错
    private lateinit var remoteDataSource: RemoteDataSource
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 适配 supportActionBar（若布局/主题无ActionBar，可改为 actionBar 或注释）
        supportActionBar?.title = "PaiLieSan"
        remoteDataSource = RemoteDataSource()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
