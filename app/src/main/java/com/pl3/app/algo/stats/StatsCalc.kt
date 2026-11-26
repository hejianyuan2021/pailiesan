package com.pl3.app.algo.stats

import com.pl3.app.algo.entity.Draw
import com.pl3.app.algo.util.MathUtil

object StatsCalc {
    fun freqMap(list: List<Draw>): Map<Int, Int> {
        val map = mutableMapOf<Int, Int>()
        list.forEach { d -> d.digits().forEach { map[it] = map.getOrDefault(it, 0) + 1 } }
        return map
    }

    fun oddEvenRatio(list: List<Draw>): Pair<Int, Int> {
        var odd = 0; var even = 0
        list.forEach { d -> d.digits().forEach { if (it % 2 == 0) even++ else odd++ } }
        return Pair(odd, even)
    }

    fun lastCombo(draw: Draw): String = MathUtil.combo(draw.digits())
}
