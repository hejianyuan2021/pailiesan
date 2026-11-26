package com.pl3.app.algo.recommend

import com.pl3.app.algo.entity.Draw
import com.pl3.app.algo.stats.StatsCalc
import kotlin.random.Random

// 一组推荐
data class Pick(
    val num: String,        // 如 "3 8 5"
    val digits: List<Int>,
    val reason: String,     // 推荐理由
    val score: Int          // 综合评分（越高越优先）
)

object RecommendEngine {

    // 基于全量历史生成 n 组推荐
    fun recommend(list: List<Draw>, n: Int = 5): List<Pick> {
        if (list.isEmpty()) return emptyList()
        val stats = StatsCalc.calc(list)
        val rnd = Random(System.currentTimeMillis())
        val result = linkedSetOf<Pick>()

        // 策略1：3 位各取最热号，组合
        var guard = 0
        while (result.size < n && guard++ < 200) {
            val d = List(3) { pos ->
                val pool = if (rnd.nextDouble() < 0.6) stats.hot[pos] else stats.cold[pos]
                pool.random(rnd)
            }
            val score = d.sumOf { stats.freq[0].size.let { 0 } + scoreOf(it, stats) }
            val pick = Pick(
                num = d.joinToString(" "),
                digits = d,
                reason = buildReason(d, stats),
                score = score
            )
            result.add(pick)
        }

        return result.sortedByDescending { it.score }.take(n)
    }

    // 评分：高频 + 低遗漏
    private fun scoreOf(n: Int, stats: com.pl3.app.algo.stats.Stats): Int {
        val pos0 = 0
        // 取三位平均频次与遗漏作为评分依据
        val avgFreq = (stats.freq[0][n] + stats.freq[1][n] + stats.freq[2][n]) / 3
        val avgMiss = (stats.miss[0][n] + stats.miss[1][n] + stats.miss[2][n]) / 3
        return avgFreq + (30 - avgMiss.coerceAtMost(30)) / 3
    }

    private fun buildReason(d: List<Int>, stats: com.pl3.app.algo.stats.Stats): String {
        var odd = 0; var even = 0; var big = 0; var small = 0
        d.forEach { n ->
            if (n % 2 == 0) even++ else odd++
            if (n >= 5) big++ else small++
        }
        val hotCnt = d.count { n -> stats.hot.any { it.contains(n) } }
        return "奇偶 $odd:$even · 大小 $big:$small · 热号命中 $hotCnt/3"
    }
}
