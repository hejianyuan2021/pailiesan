package com.pl3.app.algo.stats

import com.pl3.app.algo.entity.Draw

// 全期统计结果
data class Stats(
    val total: Int,                     // 总期数
    val freq: List<Int>,                // 每位 0-9 出现次数（长度 3，每项 size=10）
    val miss: List<Int>,                // 当前遗漏（每位 0-9 多少期未出）
    val oddEven: Pair<Int, Int>,        // 整体奇偶比
    val bigSmall: Pair<Int, Int>,       // 整体大小比（>=5 为大）
    val hot: List<List<Int>>,           // 每位最热 3 个数字
    val cold: List<List<Int>>           // 每位最冷 3 个数字
)

object StatsCalc {

    // 传入全量历史（调用方保证按时间升序，index 0 = 最早）
    fun calc(list: List<Draw>): Stats {
        val total = list.size
        // 每位每个数字的计数
        val freq = List(3) { IntArray(10) }
        list.forEach { d ->
            d.digits().forEachIndexed { pos, n ->
                if (n in 0..9) freq[pos][n]++
            }
        }

        // 遗漏：从最新往回找，找到即停
        val miss = List(3) { IntArray(10) { total } }
        for (pos in 0..2) {
            val seen = BooleanArray(10)
            for (i in list.indices.reversed()) {
                val n = list[i].digits()[pos]
                if (n in 0..9 && !seen[n]) {
                    seen[n] = true
                    miss[pos][n] = total - 1 - i
                }
                if (seen.all { it }) break
            }
        }

        // 奇偶 / 大小
        var odd = 0; var even = 0; var big = 0; var small = 0
        list.forEach { d ->
            d.digits().forEach { n ->
                if (n % 2 == 0) even++ else odd++
                if (n >= 5) big++ else small++
            }
        }

        // 每位热号 / 冷号 Top3
        val hot = List(3) { pos ->
            freq[pos].indices.sortedByDescending { freq[pos][it] }.take(3)
        }
        val cold = List(3) { pos ->
            freq[pos].indices.sortedBy { freq[pos][it] }.take(3)
        }

        return Stats(
            total = total,
            freq = freq.map { it.toList() },
            miss = miss.map { it.toList() },
            oddEven = Pair(odd, even),
            bigSmall = Pair(big, small),
            hot = hot,
            cold = cold
        )
    }
}
