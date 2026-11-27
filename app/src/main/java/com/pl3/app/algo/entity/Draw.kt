package com.pl3.app.algo.entity

// 排列三开奖实体: 期号, 百位, 十位, 个位, 日期
data class Draw(
    val issue: String,
    val bai: Int,
    val shi: Int,
    val ge: Int,
    val date: String = ""
) {
    fun digits(): List<Int> = listOf(bai, shi, ge)
}
