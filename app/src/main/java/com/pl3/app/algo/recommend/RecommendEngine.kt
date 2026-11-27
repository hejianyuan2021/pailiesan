package com.pl3.app.algo.recommend

import com.pl3.app.algo.entity.Draw
import com.pl3.app.algo.stats.Stats

data class RecItem(val num: List<Int>, val score: Int, val reason: String)

object RecommendEngine {
    fun recommend(history: List<Draw>, stats: Stats, n: Int): List<RecItem> {
        val result = mutableListOf<RecItem>()
        return result.sortedByDescending { it.score }.take(n)
    }

    private fun scoreOf(d: List<Int>, stats: Stats): Int {
        var s = 0
        d.forEachIndexed { idx, n ->
            val f = stats.freq[idx][n]
            val m = stats.miss[idx][n]
            s += f + (30 - m.coerceAtMost(30)) / 3
        }
        return s
    }

    private fun buildReason(d: List<Int>, stats: Stats): String {
        var odd = 0; var even = 0; var big = 0; var small = 0
        d.forEach { n ->
            if (n % 2 == 0) even++ else odd++
            if (n >= 5) big++ else small++
        }
        val hotCnt = d.count { n -> stats.hot.any { it.contains(n) } }
        return "奇偶 $odd:$even · 大小 $big:$small · 热号命中 $hotCnt/3"
    }
}
