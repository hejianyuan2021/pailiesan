package com.pl3.app.net

import com.pl3.app.algo.entity.Draw
import com.pl3.app.data.DataSource
import okhttp3.OkHttpClient
import okhttp3.Request
import java.util.concurrent.TimeUnit

class RemoteDataSource : DataSource {
    private val client = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(10, TimeUnit.SECONDS)
        .build()

    override suspend fun fetchHistory(): List<Draw> {
        val req = Request.Builder()
            .url("https://www.17500.cn/pl3/history.csv")
            .build()
        val resp = client.newCall(req).execute()
        val body = resp.body?.string() ?: ""
        val list = mutableListOf<Draw>()
        body.lines().filter { it.isNotBlank() }.forEach { line ->
            val p = line.split(",")
            if (p.size >= 4) {
                list.add(
                    Draw(
                        p[0].trim(),
                        p[1].trim().toIntOrNull() ?: 0,
                        p[2].trim().toIntOrNull() ?: 0,
                        p[3].trim().toIntOrNull() ?: 0,
                        ""
                    )
                )
            }
        }
        return list.reversed()
    }
}
