package com.pl3.app.algo.recommend

import com.pl3.app.algo.calc.PickCalc
import com.pl3.app.algo.entity.Draw
import kotlin.random.Random

object RecommendEngine {
    fun recommend(history: List<Draw>, count: Int = 5): List<String> {
        if (history.isEmpty()) return emptyList()
        val hot = PickCalc.hotNumbers(history)
        val cold = PickCalc.coldNumbers(history)
        val pool = (hot + cold).distinct().ifEmpty { (0..9).toList() }
        val res = mutableSetOf<String>()
        while (res.size < count) {
            val a = pool[Random.nextInt(pool.size)]
            val b = pool[Random.nextInt(pool.size)]
            val c = pool[Random.nextInt(pool.size)]
            res.add("%d%d%d".format(a, b, c))
        }
        return res.toList()
    }
}
