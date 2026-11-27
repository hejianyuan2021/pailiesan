package com.pl3.app.algo.stats

import com.pl3.app.algo.entity.Draw
import com.pl3.app.algo.util.MathUtil

// 统计结果
data class Stats(
    val freq: List<Map<Int, Int>>,   // 三位各数字频次 [pos0, pos1, pos2]
    val miss: List<Map<Int, Int>>,   // 三位各数字当前遗漏
    val hot: List<List<Int>>,        // 三位最热号(前3)
    val cold: List<List<Int>>,       // 三位最冷号(前3)
    val oddEven: Pair<Int, Int>,     // 全期奇偶比
    val lastCombo: String            // 上期奇偶大小组合
) {
    companion object {
        fun empty(): Stats {
            val e = (0..9).associateWith { 0 }
            val le = List(3) { e }
            return Stats(le, le, List(3) { emptyList() }, List(3) { emptyList() }, Pair(0,0), "")
        }
    }
}

object StatsCalc {
    // 全量期数统计（全期）
    fun calc(list: List<Draw>): Stats {
        if (list.isEmpty()) return Stats.empty()
        val freq = List(3) { mutableMapOf<Int, Int>().withDefault { 0 } }
        val miss = List(3) { mutableMapOf<Int, Int>().withDefault { 0 } }

        list.forEach { d ->
            d.digits().forEachIndexed { idx, n ->
                freq[idx][n] = freq[idx].getValue(n) + 1
            }
        }

        // 计算遗漏（从最新一期往前推）
        val rev = list.reversed()
        rev.forEach { d ->
            d.digits().forEachIndexed { idx, n ->
                if (miss[idx].getValue(n) == 0 && d != rev.first()) {
                    miss[idx][n] = miss[idx].getValue(n)
                }
            }
        }
        // 简化遗漏：用总期数 - 频次估算
        val total = list.size
        val missEst = List(3) { i ->
            (0..9).associateWith { total - (freq[i].getValue(it)) }.toMutableMap()
        }

        val hot = freq.map { m -> m.entries.sortedByDescending { it.value }.take(3).map { it.key } }
        val cold = freq.map { m -> m.entries.sortedBy { it.value }.take(3).map { it.key } }

        var odd = 0; var even = 0
        list.forEach { d ->
            d.digits().forEach { if (it % 2 == 0) even++ else odd++ }
        }

        return Stats(
            freq = freq.map { it.toMap() },
            miss = missEst,
            hot = hot,
            cold = cold,
            oddEven = Pair(odd, even),
            lastCombo = MathUtil.combo(list.last().digits())
        )
    }
}
