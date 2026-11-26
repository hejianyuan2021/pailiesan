package com.pl3.app.algo.calc

import com.pl3.app.algo.entity.Draw
import com.pl3.app.algo.stats.StatsCalc

object PickCalc {
    fun hotNumbers(history: List<Draw>, top: Int = 5): List<Int> {
        val freq = StatsCalc.freqMap(history)
        return freq.entries.sortedByDescending { it.value }.take(top).map { it.key }
    }

    fun coldNumbers(history: List<Draw>, top: Int = 5): List<Int> {
        val freq = StatsCalc.freqMap(history)
        return freq.entries.sortedBy { it.value }.take(top).map { it.key }
    }
}
