package com.pl3.app.algo.stats

class Stats(
    val freq: Array<IntArray>,
    val miss: Array<IntArray>,
    val hot: List<Set<Int>>
) {
    companion object {
        fun empty(): Stats = Stats(
            Array(3) { IntArray(10) },
            Array(3) { IntArray(10) },
            emptyList()
        )
    }
}
